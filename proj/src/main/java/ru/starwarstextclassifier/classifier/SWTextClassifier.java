package ru.starwarstextclassifier.classifier;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import weka.classifiers.Classifier;
import weka.core.Attribute;
import weka.core.DenseInstance;
import weka.core.Instances;
import weka.core.SerializationHelper;

public class SWTextClassifier {
    private Classifier classifier;
    private ArrayList<String> wordVector;
    
    public SWTextClassifier() throws Exception {
        classifier = (Classifier) SerializationHelper.read(new FileInputStream("SWtext.model"));
        
        wordVector = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("SWwordVector.txt"), "UTF8"));
        String line = reader.readLine();
        while (line != null) {
            wordVector.add(line);
            line = reader.readLine();
        }
    }
    
    public TextClass classify(String text) throws Exception {
        String[] rawWords = text.split("\\s+");
        
        ArrayList<String> words = new ArrayList<>();
        for (int i = 0; i < rawWords.length; ++i) {
            String word = rawWords[i].toLowerCase().replaceAll("[.,\\/#!\\?$%\\^&\\*;:{}=_`~()]", "");
            if (!word.isEmpty()) {
                words.add(word);
            }
        }
        
        double[] valueVector = new double[wordVector.size() + 1];
        for (int i = 0; i < valueVector.length; ++i) {
            valueVector[i] = 0;
        }
        
        for (int i = 0; i < words.size(); ++i) {
            Integer wordIndex = wordVector.indexOf(words.get(i));
            if (wordIndex != -1) {
                valueVector[wordIndex] = valueVector[wordIndex] + 1;
            }
        }
        
        ArrayList<String> textClasses = new ArrayList<>();
        for (int i = 0; i < TextClass.values().length; ++i) {
            textClasses.add(TextClass.values()[i].getName());
        }
        Attribute classAttribute = new Attribute("text_class", textClasses);
        
        ArrayList<Attribute> attributeNames = new ArrayList<>();
        for (int i = 0; i < wordVector.size(); ++i) {
            attributeNames.add(new Attribute("word_" + (i + 1)));
        }
        attributeNames.add(classAttribute);
        
        Instances vectorizedText;
        vectorizedText = new Instances("text", attributeNames, 0);
        vectorizedText.setClass(classAttribute);
        vectorizedText.add(new DenseInstance(1.0, valueVector));
        vectorizedText.instance(0).setClassMissing();
        
        return TextClass.values()[(int)classifier.classifyInstance(vectorizedText.firstInstance())];
    }
}
