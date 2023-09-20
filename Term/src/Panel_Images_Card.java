import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Panel_Images_Card extends JPanel{

    public CardLayout cardlayout = new CardLayout();
    Panel_Images panel_images = new Panel_Images();   //이미지들
    Panel_Images1 panel_images1 = new Panel_Images1();   //이미지들 ( 두번째칸)

    public Panel_Images_Card(){
        setLayout(cardlayout);

        add("panel",panel_images); //카드 패널1
        add("panel1",panel_images1 ); //카드 패널2
        setSize(600,400);   //한 칸당 250(가로) x 180(세로)

    }
    class Panel_Images extends JPanel { //이미지카드1
        public String[] array_button_name = {"엔플라잉 - Flashback","루시 - 개화", "원위 - 야행성", "SamRyder - Tiny Riot",  "루시 - Hero", "엔플라잉 - 피었습니다."};
        public String[] array_images_path = {"image/best/flashback.png","image/best/Lucy_flowering.png","image/best/Onewe_regulus.png","image/best/Samryder_tinyriot.png","image/best/Lucy_hero.png","image/best/Nflying_Intobloom.png"}; //이미지 경로 배열
        public String[] array_music_path = {"music/Nflying_flashback.wav","music/Lucy_flowering.wav","music/Onewe_regulus.wav","music/Samryder_tinyriot.wav","music/Lucy_hero.wav","music/Nflying_Intobloom.wav"}; //이미지 경로 배열

        public Frame_Music[] frame_music = new Frame_Music[6];    //음악 객체 배열 생성
        JButton button_images[] = new JButton[6];
        public Panel_Images() {
            setLayout(new GridLayout(2, 3)); //row 2, clos 3 레이아웃

                                            //버튼이름, 이미지
            for (int j = 0; j < button_images.length; j++) {
                button_images[j] = new JButton(array_button_name[j], new ImageIcon(array_images_path[j]));
            }

            for (int i = 0; i < button_images.length; i++) {    //패널에 버튼 추가
                add(button_images[i]);
            }

            for(int i = 0; i<button_images.length; i++){    //음악기능 넣기
                frame_music[i] = new Frame_Music(); //객체 내 생성
                frame_music[i].setTitle(array_button_name[i]);  //노래에 따라 title 이름 설정
                frame_music[i].loadAudio(array_music_path[i]);  //노래 기능 추가
            }


            setSize(600, 400);   //가로 200, 세로 450
        }
    }

    class Panel_Images1 extends JPanel {    //이미지카드2
        JButton button_images1[] = new JButton[6];

        public String[] array_button_name1 = {"에이티즈 - WAVE","창모 - START", "미란이 - Daisy", "Day6 - 한페이지가될수있게",  "아이유 - Into the I_LAND", "윤하 - 오르트구름"};// 버튼 이름 배열
        public String[] array_images_path1 = {"image/best/Ateez_wave.png","image/best/Changmo_start.png","image/best/Mirani_daisy.png","image/best/Day6_timeofourlife.png","image/best/Iu_intotheiland.png","image/best/Younha_oortcloud.png"};  //이미지 경로 배열
        public String[] array_music_path1 = {"music/Ateez_wave.wav","music/Changmo_start.wav","music/Mirani_daisy.wav","music/Day6_timeofourlife.wav","music/Iu_intotheiland.wav","music/Younha_oortcloud.wav"}; //이미지 경로 배열
        public Frame_Music[] frame_music = new Frame_Music[6];    //음악 객체 배열 생성
        public Panel_Images1() {
            setLayout(new GridLayout(2, 3)); //row 2, clos 3 레이아웃

            for (int j = 0; j < button_images1.length; j++) {   //버튼생성
                button_images1[j] = new JButton(array_button_name1[j], new ImageIcon(array_images_path1[j]));
            }

            for (int i = 0; i < button_images1.length; i++) {   //패널에 버튼 추가
                add(button_images1[i]);
            }

            for(int i = 0; i<button_images1.length; i++){    //음악기능 넣기
                frame_music[i] = new Frame_Music(); //객체 내 생성
                frame_music[i].setTitle(array_button_name1[i]);  //노래에 따라 title 이름 설정
                frame_music[i].loadAudio(array_music_path1[i]);  //노래 기능 추가
            }
            setSize(600, 400);   //가로 200, 세로 450
        }
    }
}

