import java.util.ArrayList;
import java.util.List;


public class Destination {

    private String name;
    private List<Destination> dependencies;
    private boolean visited;
    private List<String> destinationNames = new ArrayList<>();

    public Destination(String name) {
        this.name = name;
    }

    public List<String> planDestination(Destination... destinations) {
        for(Destination destination : destinations) {
            order(destination);
        }
        return destinationNames;
    }

    private void order(Destination destination) {
        if (destination.isVisited()) {
            return;
        }

        destination.setVisited(true);
        if(destination.getDependencies() != null) {
            for (Destination dependency : destination.getDependencies()) {
                order(dependency);
            }
        }
        destinationNames.add(0, destination.getName());
    }

    public String getName() {
        return name;
    }

    public List<Destination> getDependencies() {
        return dependencies;
    }

    public void setDependencies(List<Destination> dependencies) {
        this.dependencies = dependencies;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }
}
