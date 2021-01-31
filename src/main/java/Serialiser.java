import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Serialiser {
    private ObjectMapper om;

    public Serialiser() {
        this.om = new ObjectMapper();
    }

    public String serialise(Object o) {
        try {
            return om.writer().writeValueAsString(o);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<String> serialise(List<Object> objects) {
        return objects.stream()
                .map(this::serialise)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    public <T> T deserialize(String s, Class<T> clazz) {
        try {
            return om.readerFor(clazz).readValue(s);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public <T> List<T> deserialize(List<String> list, Class<T> clazz) {
        return list.stream()
                .map(l -> this.deserialize(l, clazz))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }
}
