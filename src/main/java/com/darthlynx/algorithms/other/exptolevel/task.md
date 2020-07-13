Get the right level by experience


```
public Map<Integer, Long> getLevelToMinExperienceMapping() {
        Map<Integer, Long> levelToMinExperienceMapping = new HashMap<>();
        levelToMinExperienceMapping.put(1, 0L);
        levelToMinExperienceMapping.put(2, 100L);
        levelToMinExperienceMapping.put(3, 500L);
        levelToMinExperienceMapping.put(4, 1000L);
        levelToMinExperienceMapping.put(5, 2500L);
        levelToMinExperienceMapping.put(6, 5000L);
        levelToMinExperienceMapping.put(7, 10000L);
        // ...
        return levelToMinExperienceMapping;
        
  
}

public Integer getLevelByExperience(long exp) {  
  
}
```