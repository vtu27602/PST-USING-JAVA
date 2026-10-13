import java.util.*;

class ThroneInheritance {

    private String king;
    private Map<String, List<String>> family;
    private Set<String> dead;

    public ThroneInheritance(String kingName) {
        king = kingName;
        family = new HashMap<>();
        dead = new HashSet<>();
    }

    public void birth(String parentName, String childName) {
        family.computeIfAbsent(parentName, k -> new ArrayList<>())
              .add(childName);
    }

    public void death(String name) {
        dead.add(name);
    }

    public List<String> getInheritanceOrder() {
        List<String> result = new ArrayList<>();

        dfs(king, result);

        return result;
    }

    private void dfs(String person, List<String> result) {

        // Add person if alive
        if (!dead.contains(person)) {
            result.add(person);
        }

        // Visit children in birth order
        if (family.containsKey(person)) {
            for (String child : family.get(person)) {
                dfs(child, result);
            }
        }
    }
}
[king, andy, matthew, bob, alex, asha, catherine]
[king, andy, matthew, alex, asha, catherine]
