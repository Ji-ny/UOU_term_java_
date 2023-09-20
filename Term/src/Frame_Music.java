import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Frame_Music extends JFrame {

    public JButton btns[] = { new JButton("play"),
            new JButton("stop"), new JButton("play again")};
    public Clip clip;
    public Frame_Music() {


        setTitle("노래 재생 설정");
//        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //윈도우 키 클릭 시 리스너 설정
        addWindowListener(new WindowAdapter() {     //윈도우 X 창 누르면
            @Override
            public void windowClosing(WindowEvent e) {
                clip.stop();        //  노래 종료
                super.windowClosing(e);
                dispose();          // 이 프레임만 닫기
            }
        });
        setSize(300,100);   //사이즈 설정
        Container c = getContentPane();
        c.setBackground(new Color(239,215,216));   //배경 색 설정
        c.setLayout(new FlowLayout());
        MyActionListener al = new MyActionListener();
        for(int i=0; i<btns.length; i++) {  //버튼에 이벤트 삽입
            btns[i].setBackground(Color.PINK);  //버튼 색 pink
            c.add(btns[i]);
            btns[i].addActionListener(al);
        }
        setVisible(false);  //visible flase

    }


    /* 오디오 클립 만들기 */
    public void loadAudio(String pathName) {   //파일 경로 입력받음
        try {
            clip = AudioSystem.getClip(); // 비어있는 오디오 클립 만들기
            File audioFile = new File(pathName); // 오디오 파일의 경로명
            AudioInputStream audioStream =
                    AudioSystem.getAudioInputStream(audioFile);
            clip.open(audioStream); // 재생할 오디오 스트림 열기
        }
        catch (LineUnavailableException e) { e.printStackTrace(); }
        catch (UnsupportedAudioFileException e) { e.printStackTrace(); }
        catch (IOException e) { e.printStackTrace(); }
    }

    /* 이벤트 처리 */
    public class MyActionListener implements ActionListener {  //이벤트처리
        public void actionPerformed(ActionEvent e) {
            switch(e.getActionCommand()) {
                case "play": clip.start(); // 오디오 재생 시작
                    break;
                case "stop": clip.stop(); // 오디오 재생 중단
                    break;
                case "play again": clip.setFramePosition(0);    //오디오 다시 재생
                    clip.start();
                    break;
            }
        }
    }
    public static void main(String [] args) {
        new Frame_Music();
    }
}

