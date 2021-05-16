package com.changui.payoneerhomeexercise;

import com.changui.payoneerhomeexercise.data.apiresponse.PaymentMethodsApiResponse;
import com.changui.payoneerhomeexercise.domain.PaymentMethodUIModel;
import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Utils {
    private static String loadJsonResource(String jsonResource) throws IOException {
        InputStream inputStream = Utils.class.getClassLoader()
                .getResourceAsStream("json/" + jsonResource);

        int size = inputStream.available();
        byte[] buffer = new byte[size];
        inputStream.read(buffer);
        inputStream.close();

        return new String(buffer, "UTF-8");
    }

    private static List<PaymentMethodUIModel> createPaymentMethods(String dataSetAsString) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        Type listType = new TypeToken<ArrayList<PaymentMethodUIModel>>() {}.getType();

        return gson.fromJson(dataSetAsString, listType);
    }

    private static <T> T generateSingleResource(String dataSetAsString, Class<T> K){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.addDeserializationExclusionStrategy(new SuperclassExclusionStrategy());
        gsonBuilder.addSerializationExclusionStrategy(new SuperclassExclusionStrategy());

        Gson gson = gsonBuilder.create();

        ResourceGenerator<T> resourceGenerator = new ResourceGenerator<>(K);

        return gson.fromJson(dataSetAsString, resourceGenerator.getType());
    }

    private static class SuperclassExclusionStrategy implements ExclusionStrategy
    {
        public boolean shouldSkipClass(Class<?> arg0)
        {
            return false;
        }

        public boolean shouldSkipField(FieldAttributes fieldAttributes)
        {
            String fieldName = fieldAttributes.getName();
            Class<?> theClass = fieldAttributes.getDeclaringClass();

            return isFieldInSuperclass(theClass, fieldName);
        }

        private boolean isFieldInSuperclass(Class<?> subclass, String fieldName)
        {
            Class<?> superclass = subclass.getSuperclass();
            Field field;

            while(superclass != null)
            {
                field = getField(superclass, fieldName);

                if(field != null)
                    return true;

                superclass = superclass.getSuperclass();
            }

            return false;
        }

        private Field getField(Class<?> theClass, String fieldName)
        {
            try
            {
                return theClass.getDeclaredField(fieldName);
            }
            catch(Exception e)
            {
                return null;
            }
        }
    }

    private static class ResourceGenerator<T>
    {
        private Class<T> type;

        public ResourceGenerator(Class<T> type) {
            this.type = type;
        }

        public Class<T> getType() {
            return this.type;
        }

    }

    public static List<PaymentMethodUIModel> getMethods() throws IOException {
        String categoryResource = loadJsonResource("payment_methods.json");
        return createPaymentMethods(categoryResource);
    }

    public static PaymentMethodsApiResponse getApiResponse() throws IOException {
        String adResource = loadJsonResource("api.json");
        return generateSingleResource(adResource, PaymentMethodsApiResponse.class);
    }
}
