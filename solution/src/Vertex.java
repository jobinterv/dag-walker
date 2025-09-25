import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/*
Vertex is an immutable class in which its own id and neighbor vertices represented by their corresponding ids are captured.
An instance of Vertex can only be created via a factory method to ensure the basic criteria is met before creation.
 */

public class Vertex {
    private Long id;

    private List<Long> nextIds;

    public static Vertex instance(Long id, Long[] nextIds){
        if(id == null)
            throw new IllegalArgumentException("vertex id cannot be null");

        return new Vertex(id, Arrays.asList(nextIds));
    }

    private Vertex(){}

    private Vertex(Long id, List<Long> nextIds) {
        this.id = id;
        this.nextIds = nextIds;
    }

    public Long getId() {
        return id;
    }

    public List<Long> getNextIds() {
        return nextIds;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Vertex vertex = (Vertex) o;
        return Objects.equals(id, vertex.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "id=" + id +
                ", nextIds=" + nextIds +
                '}';
    }
}
