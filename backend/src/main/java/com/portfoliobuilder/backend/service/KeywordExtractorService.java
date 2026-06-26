package com.portfoliobuilder.backend.service;

import com.portfoliobuilder.backend.util.SkillDictionary;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class KeywordExtractorService {

    public Set<String> extractSkills(
            String text
    ) {

        Set<String> found =
                new HashSet<>();

        if (text == null) {
            return found;
        }

        String lower =
                text.toLowerCase();

        for (String skill :
                SkillDictionary.SKILLS) {

            if (lower.contains(skill)) {
                found.add(skill);
            }
        }

        return found;
    }
}