import javax.swing.*;
import java.awt.*;

public class Panel_Images_Card2 extends JPanel{

    public CardLayout cardlayout = new CardLayout();
    Panel_Images panel_images = new Panel_Images();   //이미지들
    Panel_Images1 panel_images1 = new Panel_Images1();   //이미지들 ( 두번째칸)

    public Panel_Images_Card2(){
        setLayout(cardlayout);

        add("panel",panel_images); //카드 패널1
        add("panel1",panel_images1 ); //카드 패널2
        setSize(600,400);

    }
    class Panel_Images extends JPanel { //이미지카드1
        public String[] array_button_name = {"SamRyder - Tiny Riot","Kelly Clarkson - stronger",  "하현우 - 돌덩이", "아이유 - Celebrity", "미란이, 먼치맨, Khundi Panda, 머쉬베놈 - VVS", "AJR - Burn The House Down",};
        public String[] array_images_path = {"image/stronger/Samryder_tinyriot.png","image/stronger/Kellyclarkson_stronger.png","image/stronger/Hahyunwoo_stoneblock.png","image/stronger/Iu_celebrity.png","image/stronger/vvs.png","image/stronger/Ajr_burnthehousedown.png"}; //이미지 경로 배열
        public String[] array_music_path = {"music/Samryder_tinyriot.wav","music/Kellyclarkson_stronger.wav","music/Hahyunwoo_stoneblock.wav","music/Iu_celebrity.wav","music/vvs.wav","music/Ajr_burnthehousedown.wav"}; //이미지 경로 배열

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

        public String[] array_button_name1 = {"가호 - 시작","Avicii - The Nights","한요한 - 400km","Unlike Pluto - Everything Black","Coldplay - Viva La Vida","GOT the beat - Step Back"};// 버튼 이름 배열
        public String[] array_images_path1 = {"image/stronger/Gaho_startover.png","image/stronger/Avicii_thenights.png","image/stronger/Hanyohan_400km.png","image/stronger/unlikepluto_everythingblack.png","image/stronger/Coldplay_vivalavida.png","image/stronger/Gotthebeat_stepback.png"};  //이미지 경로 배열
        public String[] array_music_path1 = {"music/Gaho_startover.wav","music/Avicii_thenights.wav","music/Hanyohan_400km.wav","music/unlikepluto_everythingblack.wav","music/Coldplay_vivalavida.wav","music/Gotthebeat_stepback.wav"}; //이미지 경로 배열
        public Frame_Music[] frame_music = new Frame_Music[6];    //음악 객체 배열 생성
        public Panel_Images1() {
            setLayout(new GridLayout(2, 3)); //row 2, clos 3 레이아웃

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

