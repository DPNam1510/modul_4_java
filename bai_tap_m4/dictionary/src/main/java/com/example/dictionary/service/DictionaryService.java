package com.example.dictionary.service;

import com.example.dictionary.entity.Dictionary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DictionaryService {
    private static final List<Dictionary> dictionary = new ArrayList<>();

    static {
        dictionary.add(new Dictionary("Hello", "Xin chao"));
        dictionary.add(new Dictionary("Engineer", "Ky su"));
        dictionary.add(new Dictionary("Staff", "Nhan vien"));
    }
    public String getDictionary(String word) {
        for(Dictionary d : dictionary) {
            if (d.getEnglish().equalsIgnoreCase(word)) {
                return d.getVietnam();
            }
        }
        return null;
    }
}
