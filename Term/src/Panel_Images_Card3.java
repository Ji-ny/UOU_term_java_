import javax.swing.*;
import java.awt.*;

public class Panel_Images_Card3 extends JPanel{

    public CardLayout cardlayout = new CardLayout();
    Panel_Images panel_images = new Panel_Images();   //이미지들
    Panel_Images1 panel_images1 = new Panel_Images1();   //이미지들 ( 두번째칸)

    public Panel_Images_Card3(){
        setLayout(cardlayout);

        add("panel",panel_images); //카드 패널1
        add("panel1",panel_images1 ); //카드 패널2
        setSize(600,400);

    }
    class Panel_Images extends JPanel { //이미지카드1
        public String[] array_button_name = {"CODE KUNST,최정훈,사이먼 도미닉 - 사라진 모든 것들에게","Charlie Puth - That's Hilarious", "원위 - 야행성", "스트레이 - 달",  "윤하 - WINTER FLOWER(雪中梅) ", "한요한 - 록시땅"};
        public String[] array_images_path = {"image/heart/codekunst_forthegone.png","image/heart/charlieputh_thatshilarious.png","image/heart/Onewe_regulus.png","image/heart/Thestray_moon.png","image/heart/Younha_winterflower.png","image/heart/Hanyohan_loccitane.png"}; //이미지 경로 배열
        public String[] array_music_path = {"music/codekunst_forthegone.wav","music/charlieputh_thatshilarious.wav","music/Onewe_regulus.wav","music/Thestray_moon.wav","music/Younha_winterflower.wav","music/Hanyohan_loccitane.wav"}; //이미지 경로 배열

        public Frame_Music[] frame_music = new Frame_Music[6];    //음악 객체 배열 생성
        JButton button_images[] = new JButton[6];
        public Panel_Images() {
            setLayout(new GridLayout(2, 3)); //row 2, clos 3 레이아웃
                                        //버튼 이름, 이미지
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

        public String[] array_button_name1 = {"JT Music - Join us for a bit","창모 - START", "(여자)아이들 - Change", "Hash Swan - Airplane Mode",  "창모 - 널 지워야해", "Benson Boone - Ghost Town"};// 버튼 이름 배열
        public String[] array_images_path1 = {"image/heart/Jtmusic_joinusforabite.png","image/heart/Changmo_start.png","image/heart/Idle_change.png","image/heart/Hashswan_airplanemode.png","image/heart/Changmo_eraseyou.png","image/heart/Bensonboone_ghosttown.png"};  //이미지 경로 배열
        public String[] array_music_path1 = {"music/Jtmusic_joinusforabite.wav","music/Changmo_start.wav","music/Idle_change.wav","music/Hashswan_airplanemode.wav","music/Changmo_eraseyou.wav","music/Bensonboone_ghosttown.wav"}; //이미지 경로 배열
        public Frame_Music[] frame_music = new Frame_Music[6];    //음악 객체 배열 생성Changmo_eraseyou
        public Panel_Images1() {
            setLayout(new GridLayout(2, 3)); //row 2, clos 3 레이아웃
                                    // 버튼 초기화
            for (int j = 0; j < button_images1.length; j++) {   //버튼 생성
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

