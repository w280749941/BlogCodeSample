package proxy;

public class Agent implements Artist {

    private Singer singer;

    public Agent(Singer singer) {
        this.singer = singer;
    }

    @Override
    public boolean acceptEndorsementPrice(int offer) {

        return offer >= singer.getPrice() * 2;
    }
}
