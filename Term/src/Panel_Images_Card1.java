import javax.swing.*;
import java.awt.*;

public class Panel_Images_Card1 extends JPanel{

    public CardLayout cardlayout = new CardLayout();
    Panel_Images panel_images = new Panel_Images();   //이미지들
    Panel_Images1 panel_images1 = new Panel_Images1();   //이미지들 ( 두번째칸)


    public Panel_Images_Card1(){
        setLayout(cardlayout);

        add("panel",panel_images); //카드 패널1
        add("panel1",panel_images1 ); //카드 패널2
        cardlayout.show(this, "panel");
        setSize(600,400);

    }
    class Panel_Images extends JPanel { //이미지카드1
        public String[] array_button_name = {"아이유 - Into the I-LAND","Day6 - 어쩌다보니", "권은비 - Underwater", "호피폴라 - Let's",  "Avicii - Wake me up", "윤하 - 오르트구름"};
        public String[] array_images_path = {"image/happy/Iu_intotheiland.png","image/happy/Day6_somehow.png","image/happy/Kwoneunbi_underwater.png","image/happy/Hoppipolla_let's.png","image/happy/Avicii_wakemeup.png","image/happy/Younha_oortcloud.png"}; //이미지 경로 배열

        public String[] array_music_path = {"music/Iu_intotheiland.wav","music/Day6_somehow.wav","music/Kwoneunbi_underwater.wav","music/Hoppipolla_let's.wav","music/Avicii_wakemeup.wav","music/Younha_oortcloud.wav"}; //이미지 경로 배열

        public Frame_Music[] frame_music = new Frame_Music[6];    //음악 객체 배열 생성
        JButton button_images[] = new JButton[6];


        public Panel_Images() {
            setLayout(new GridLayout(2, 3)); //row 2, clos 3 레이아웃
                                                //버튼이름, 이미지
            for (int j = 0; j < button_images.length; j++) {    //버튼 생성
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
        public String[] array_button_name1 = {"에이티즈 - WAVE","루시 - Hero", "NIziU : Make you happy", "Day6 - 한페이지가될수있게",  "엔플라잉 - 피었습니다.", "루시 - 개화"};// 버튼 이름 배열
        public String[] array_images_path1 = {"image/happy/Ateez_wave.png","image/happy/Lucy_hero.png","image/happy/Niziu_makeyouhappy.png","image/happy/Day6_timeofourlife.png","image/happy/Nflying_Intobloom.png","image/happy/Lucy_flowering.png"};  //이미지 경로 배열

        public String[] array_music_path1 = {"music/Ateez_wave.wav","music/Lucy_hero.wav","music/Day6_timeofourlife.wav","music/Day6_timeofourlife.wav","music/Nflying_Intobloom.wav","music/Lucy_flowering.wav"}; //이미지 경로 배열
        public Frame_Music[] frame_music = new Frame_Music[6];    //음악 객체 배열 생성
        public Panel_Images1() {
            setLayout(new GridLayout(2, 3)); //row 2, clos 3 레이아웃

            for (int j = 0; j < button_images1.length; j++) {       //버튼 생성
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

