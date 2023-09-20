import javax.swing.*;
import java.awt.*;

public class Label_Explain {
    JLabel explain = new JLabel();
    Label_Explain(){
        explain.setBackground(Color.white);
        explain.setPreferredSize(new Dimension(600,50));
        explain.setHorizontalAlignment(SwingConstants.CENTER);   //가운대 정렬
        explain.setFont(new Font("돋움", Font.BOLD, 20));    //폰트 설정
        explain.setText("Explain");

        explain.setForeground(Color.MAGENTA);

    }
}
