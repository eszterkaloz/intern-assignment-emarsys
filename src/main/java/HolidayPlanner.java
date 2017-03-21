import java.util.ArrayList;
import java.util.List;

public class HolidayPlanner {
    private List<String> destinationNames = new ArrayList<>();

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
}
