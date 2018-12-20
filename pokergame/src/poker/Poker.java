package poker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author:LiuYun
 * @Date:2018/12/20 18:30
 */
public class Poker implements Comparable<Poker> {
    String key;
    String value;
    String[] KEY = {"方块", "梅花", "红桃", "黑桃"};
    String[] VALUE = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};

    public Poker(String key, String value) {
        this.key = key;
        this.value = value;
    }
    @Override
    public String toString(){
        return key+value;
    }
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public int compareTo(Poker o) {
        List<String> keys = Arrays.asList(KEY);
        List<String> values = Arrays.asList(VALUE);
        //比较牌的大小，如果大小相等，比较花色
        if (values.indexOf(this.value) == values.indexOf(o.getValue())) {
            if (keys.indexOf(this.key) == keys.indexOf(o.getKey())) {
                return 0;
            } else {
                return keys.indexOf(this.key) - keys.indexOf(o.getKey());
            }
        } else {
            return values.indexOf(this.value) - values.indexOf(o.getValue());
        }
    }
}
