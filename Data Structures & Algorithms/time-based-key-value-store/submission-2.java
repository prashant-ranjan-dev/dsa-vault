class TimeMap {
    class Pair{
        int timestamp;
        String value;

        public Pair(int timestamp, String value){
            this.timestamp = timestamp;
            this.value = value;
        }
    }
    HashMap<String, ArrayList<Pair>> values;

    public TimeMap() {
        values = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        values.computeIfAbsent(key, k -> new ArrayList<>()).add(new Pair(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        if(!values.containsKey(key)){
            return "";
        }
        ArrayList<Pair> valuesAtTimes = values.get(key);
        int left = 0, right = valuesAtTimes.size()-1;
        String res = "";

        while(left <= right){
            int mid = left + (right - left)/ 2;

            Pair midValue = valuesAtTimes.get(mid);

            if(midValue.timestamp <= timestamp){
                res = midValue.value;
                left = mid + 1;
            } else{
                right = mid - 1;
            }
        }
        return res;
    }
}