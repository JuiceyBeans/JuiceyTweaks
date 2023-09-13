package com.juicey.juiceytweaks.mixin;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.logging.log4j.LogManager;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class MixinFeatureManager {

    //Mixin config adapted from BedrockIfy (https://github.com/juancarloscp52/BedrockIfy)
    public static Map<String, Boolean> features = new HashMap<>();
    static {
        features.put("TorchflowerGlowMixin", true);
        features.put("SnowballFreezingMixin", true);
        features.put("FoodMixin", true);
    }

    public static boolean isFeatureEnabled(String mixin){
        mixin = mixin.replace("com.juicey.juiceytweaks.mixin.","");
        String [] split = mixin.split("\\.");
        mixin = mixin.replace("."+split[split.length-1],"");
        return features.get(mixin);
    }

    public static void loadMixinSettings() {
        File file = new File("./config/juiceytweaks/juiceyMixins.json");
        Gson gson = new Gson();
        if (file.exists()) {
            try {
                FileReader fileReader = new FileReader(file);
                Type mapType = new TypeToken<Map<String,Boolean>>() {}.getType();
                Map<String,Boolean> newFeatures = gson.fromJson(fileReader, mapType);
                features.replaceAll((key,value) -> {
                    if(newFeatures.get(key) !=null){
                        return newFeatures.get(key);
                    }else{
                        return value;
                    }
                });
                fileReader.close();
            } catch (Exception e) {
                LogManager.getLogger().warn("Could not load Juicey's Tweaks Mixin settings, creating new config. ERROR: " + e.getLocalizedMessage());
                saveMixinSettings();
            }
        } else {
            LogManager.getLogger().warn("Juicey's Tweaks Mixin Config not found, creating new config.");

            saveMixinSettings();
        }
    }

    public static void saveMixinSettings() {
        Gson gson = new Gson();
        File file = new File("./config/juiceytweaks/juiceyMixins.json");
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdir();
        }
        try {
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(gson.toJson(features));
            fileWriter.close();
        } catch (IOException e) {
            LogManager.getLogger().warn("Could not save Juicey's Tweaks Mixin settings: " + e.getLocalizedMessage());
        }
    }
}
