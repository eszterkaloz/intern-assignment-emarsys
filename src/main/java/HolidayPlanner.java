import java.util.ArrayList;
import java.util.List;

public class HolidayPlanner {
    private List<String> destinationNames = new ArrayList<>();

    public List<String> planDestination(Destination... destinations) throws Exception {
        for (Destination destination : destinations) {
            order(destination);
        }
        return destinationNames;
    }

    private void order(Destination destination) throws Exception {
        if (destinationNames.contains(destination.getName())) {
            return;
        }

        if (destination.isVisited()) {
            throw new Exception("Not a DAG");
        }

        destination.setVisited(true);
        if (destination.getDependencies() != null) {
            for (Destination dependency : destination.getDependencies()) {
                order(dependency);
            }
        }

        destinationNames.add(0, destination.getName());
    }
}
