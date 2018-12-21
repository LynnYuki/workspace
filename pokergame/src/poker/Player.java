package poker;

import java.util.ArrayList;
import java.util.List;


public class Player {
    private String name;
    private String id;
    private List<Poker> playerPoker = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Poker> getPlayerPoker() {
        return playerPoker;
    }

    public void setPlayerPoker(Poker poker) {
       playerPoker.add(poker);
    }
}
