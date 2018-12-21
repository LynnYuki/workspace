package poker;

import java.util.*;

public class PokerGame {
    private List<Player> players = new ArrayList<>();
    private List<Poker> pokers = new ArrayList<>();

    public static void main(String[] args) {
        PokerGame pokerGame = new PokerGame();
        pokerGame.createPoker();
        pokerGame.createPlayer();
        pokerGame.shuffleCards();
        pokerGame.play();
    }

    public void createPlayer() {
        System.out.println("---------------------创建玩家--------------");
        for (int i = 0; i < 2; i++) {
            Player player = new Player();
            System.out.println("请输入第" + (i + 1) + "位玩家的姓名和编号：");
            System.out.println("请输入编号：");
            player.setId(new Scanner(System.in).next());
            System.out.println("请输入姓名：");
            player.setName(new Scanner(System.in).next());
            players.add(player);
        }
        for (Player play : players) {
            System.out.println("---------------欢迎玩家:" + play.getName() + "------------");
        }
    }

    public void createPoker() {
        System.out.println("-----------------创建扑克牌------------------");
        String[] KEY = {"方块", "梅花", "红桃", "黑桃"};
        String[] VALUE = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        for (int i = 0; i < KEY.length; i++) {
            for (int j = 0; j < VALUE.length; j++) {
                pokers.add(new Poker(KEY[i], VALUE[j]));
            }
        }
        System.out.println("-----------------扑克牌创建成功。----------------");
        System.out.println("为：" + Arrays.toString(pokers.toArray(new Poker[pokers.size()])) + pokers.size() + "张");
    }

    public void play() {
        System.out.println("请输入发牌张数：");
        int getPokerSize = new Scanner(System.in).nextInt();
        int pokerSize = pokers.size();
        System.out.println("------------------开始发牌-------------");
        for (int i = 0; i < getPokerSize; i++) {
            for (Player player : players) {
                int index = new Random().nextInt(pokerSize);
                System.out.println("玩家" + player.getName() + "拿牌");
                Poker poker = pokers.get(index);
                player.setPlayerPoker(poker);
                pokers.remove(index);
                pokerSize--;
            }

        }
        System.out.println("----------------------发牌结束-----------------");
        System.out.println("-------------玩家各自的手牌为：");
        ArrayList<Poker> maxPoker = new ArrayList<>();
        for (Player players : players) {
            System.out.println("整理排序前：" + players.getName() + ":" + Arrays.toString(players.getPlayerPoker().toArray(new Poker[players.getPlayerPoker().size()])));
            //排序
            Collections.sort(players.getPlayerPoker());
            //排序之后打印
            System.out.println("整理排序后：" + players.getName() + ":" + Arrays.toString(players.getPlayerPoker().toArray(new Poker[players.getPlayerPoker().size()])));
            maxPoker.add(players.getPlayerPoker().get(getPokerSize - 1));
            System.out.println("玩家" + players.getName() + "的最大手牌为：" + players.getPlayerPoker().get(getPokerSize - 1));
        }
        Collections.sort(maxPoker);
        for (int i = 0; i < 2; i++) {
            if (players.get(i).getPlayerPoker().contains(maxPoker.get(1))) {
                System.out.println("玩家" + players.get(i).getName() + "获胜");
            }
        }
    }

    public void shuffleCards() {
        System.out.println("-----------------开始洗牌------------------------");
        //洗牌
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 52; j++) {
                //随机交换牌的角标
                int endIndex = new Random().nextInt(52 - j) + j;
                Poker start = pokers.get(j);
                Poker end = pokers.get(endIndex);
                //交换位置
                pokers.set(j, end);
                pokers.set(endIndex, start);
            }
        }
        System.out.println("-------------洗牌结束------------------");
        System.out.println("-------------洗牌后顺序-----------------");
        //打印洗牌后顺序
        System.out.println("为：" + Arrays.toString(pokers.toArray(new Poker[pokers.size()])));
    }
}
