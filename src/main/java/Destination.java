import java.util.List;


public class Destination {

    private String name;
    private List<Destination> dependencies;
    private boolean visited;

    public Destination(String name) {
        this.name = name;
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
