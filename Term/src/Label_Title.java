import javax.swing.*;
import java.awt.*;

public class Label_Title {
    JLabel title = new JLabel("Jian's Playlist");
    Label_Title(){
        title.setPreferredSize(new Dimension(800,150));
        title.setHorizontalAlignment(SwingConstants.CENTER);   //가운대 정렬
        title.setFont(new Font("궁서", Font.BOLD, 50));    //폰트 설정
        title.setForeground(Color.PINK);


    }
}
