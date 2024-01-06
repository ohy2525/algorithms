package 알고리즘스터디.중급;

import java.util.*;

public class ServiceLoadFactor {
    static Map<String, Integer> loadFactor = new HashMap<>();

    public String[] getLoadFactors(String[] service_list, String entrypoint) {
        Map<String, String[]> serviceListMap = new HashMap<>();

        for (String s : service_list) {
            String key = s.split("=")[0];
            loadFactor.put(key, 0);
            if (s.split("=").length > 1) {
                String[] values = s.split("=")[1].split(",");
                serviceListMap.put(key, values);
            } else {
                serviceListMap.put(key, new String[0]);
            }
        }

        loadFactor.put(entrypoint, loadFactor.get(entrypoint) + 1);
        dfs(entrypoint, serviceListMap);

        String[] result = new String[loadFactor.size()];
        int index = 0;
        for (String key : loadFactor.keySet()) {
            result[index] = key + '*' + loadFactor.get(key);
            index++;
        }
        Arrays.sort(result);

        return result;
    }

    private static void dfs(String entrypoint, Map<String, String[]> serviceListMap) {
        String[] values = serviceListMap.get(entrypoint);
        for (String value : values) {
            if (loadFactor.containsKey(value)) {
                loadFactor.put(value, loadFactor.get(value) + 1);
                dfs(value, serviceListMap);
            }
        }
    }
}
