package handlinghttprequests.models;

import lombok.*;
import javax.persistence.*;
import java.util.Objects;
@Data
@Getter
@Setter
@Entity
@Table(name = "ActivityTable")
public class ActivityTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "activity")
    private String activity;

    @Column(name = "type")
    private String type;

    @Column(name = "participants")
    private int participants;

    private String activitykey;

    private String activityLine;

    @Column(name = "price")
    private int price;

    @Column(name = "accessibility")
    private int accessibility;

    public ActivityTable() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ActivityTable that)) return false;
        return getId() == that.getId() && getParticipants() == that.getParticipants() && getPrice() == that.getPrice() && getAccessibility() == that.getAccessibility() && Objects.equals(getActivity(), that.getActivity()) && Objects.equals(getType(), that.getType()) && Objects.equals(getActivitykey(), that.getActivitykey()) && Objects.equals(getActivityLine(), that.getActivityLine());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getActivity(), getType(), getParticipants(), getActivitykey(), getActivityLine(), getPrice(), getAccessibility());
    }

    @Override
    public String toString() {
        return "ActivityTable{" +
                "id=" + id +
                ", activity='" + activity + '\'' +
                ", type='" + type + '\'' +
                ", participants=" + participants +
                ", activitykey='" + activitykey + '\'' +
                ", activityLine='" + activityLine + '\'' +
                ", price=" + price +
                ", accessibility=" + accessibility +
                '}';
    }
}
