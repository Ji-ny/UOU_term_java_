import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.sound.sampled.*;
import java.awt.event.*;
import java.io.*;

public class Main extends JFrame{
    public Container contentPane = getContentPane();
    public Panel_Menu panel_menu = new Panel_Menu();   //메뉴 버튼
    public Panel_Images_Card_All panel_images_card_all = new Panel_Images_Card_All(); //카드들의 카드 (이미지페이지)
    public Label_Title label_title = new Label_Title();    // 제목 라벨
    public Label_Explain label_explain = new Label_Explain();  //제일 밑 설명란 라벨


    public Main(){

        /* 팝업 다이얼로그 */
                //종료하시겠습니까?
        function_endoption();
        /* 툴팁 매니저 */
        function_ToolTipManager();  //툴팁매니저 설정 (약 3초후 툴팁이 꺼진다)

        /* 컨텐트팬 생성 */
        setTitle("앨범이름");
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //x 누르면 종료
        contentPane.setLayout(new BorderLayout());  //보더 레이아웃
        setSize(800,600); //가로 1000, 세로 800;
        setVisible(true);
        contentPane.setBackground(Color.white); //백그라운드 컬러 설정

        /* 타이틀 붙이기 */
        contentPane.add(label_title.title, BorderLayout.NORTH);

        /* 버튼 붙이기 */
        contentPane.add(panel_menu, BorderLayout.WEST);

        /* 이미지 카드 붙이기 */
        contentPane.add(panel_images_card_all, BorderLayout.CENTER);    //이미지 패널 카드 , 처음 카드만 보이도록 한다.

        /* 설명란 (제일 밑)라벨 붙이기 */
        contentPane.add(label_explain.explain, BorderLayout.SOUTH);
        panel_images_card_all.cardlayout_all.show(panel_images_card_all, "card0");

        /*----키보드 리스너------*/
        key_listner();  //0번째 키보드 리스너
        key_listner1(); //1번째 키보드 리스너
        key_listner2(); //2번째 키보드 리스너
        key_listner3(); //3번재 키보드 리스너


        /*----메뉴 버튼 리스너----*/
        button_menu_listner();  //메뉴 버튼들 리스너

        /*----이미지 페이지당 6개 각각의 버튼 클릭시 리스너 String 배열----*/
        //0번째 메뉴
        button_images_listner();   //페이지1
        button_images_listner1(); //페이지2

        //1번째 메뉴
        button_images_listner_1();   //페이지1
        button_images_listner1_1(); //페이지2

        //2번째 메뉴
        button_images_listner_2();   //페이지1
        button_images_listner1_2(); //페이지2

        //3번째 메뉴
        button_images_listner_3();   //페이지1
        button_images_listner1_3(); //페이지2


    }

    public static void main(String[] args){
        Main frame = new Main();
    }



    /*---------------------------------- Panel_images_Card ------------------------------------------------------*/




    /* 메뉴 버튼 클릭 리스너 */
    //show (Container parent , String name)
    void button_menu_listner(){
        contentPane.setFocusable(true);
        contentPane.requestFocus();
        /* 0 번째 메뉴 버튼 클릭 시*/
        panel_menu.button_menu[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel_images_card_all.cardlayout_all.show(panel_images_card_all,"card");//panel 0 보이게 하기
                contentPane.setFocusable(true); //키보드 입력을 위해 포커스를 맞춤
                contentPane.requestFocus();
            }
        });
        /* 1 번째 메뉴 버튼 클릭 시*/
        panel_menu.button_menu[1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel_images_card_all.cardlayout_all.show(panel_images_card_all,"card1");//panel 0 보이게 하기
                contentPane.setFocusable(true); //키보드 입력을 위해 포커스를 맞춤
                contentPane.requestFocus();
            }
        });
        /* 2 번째 메뉴 버튼 클릭 시*/
        panel_menu.button_menu[2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel_images_card_all.cardlayout_all.show(panel_images_card_all,"card2");//panel 0 보이게 하기
                contentPane.setFocusable(true); //키보드 입력을 위해 포커스를 맞춤
                contentPane.requestFocus();
            }
        });
        /* 3 번째 메뉴 버튼 클릭 시*/
        panel_menu.button_menu[3].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel_images_card_all.cardlayout_all.show(panel_images_card_all,"card3");//panel 0 보이게 하기
                contentPane.setFocusable(true); //키보드 입력을 위해 포커스를 맞춤
                contentPane.requestFocus();
            }
        });


    }


    /*--------------------------------------------- 키보드 리스너 ------------------------------------------------------*/
    /* 0번째 키보드 리스너 */
    void key_listner(){
        contentPane.setFocusable(true);
        contentPane.requestFocus();
        contentPane.addKeyListener(new KeyAdapter() {   //keyadapter : 하고 싶은것만 만듬

            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();   //키입력받음
                if(keyCode == KeyEvent.VK_LEFT){    //왼쪽 방향키를 누를 시
                    panel_images_card_all.panel_images_card.cardlayout.previous(panel_images_card_all.panel_images_card);   //컨테이너의 이전 카드를 뽑는다.
                            // 카드 안에,   0번째 카드 안에,  다시 카드의 이전                              // 부모패널
                    contentPane.setFocusable(true);
                    contentPane.requestFocus();
                }
                if(keyCode == KeyEvent.VK_RIGHT){   //오른쪽 방향키 누를 시
                    panel_images_card_all.panel_images_card.cardlayout.next(panel_images_card_all.panel_images_card);   //컨테이너의 다음 카드를 뽑는다.
                    contentPane.setFocusable(true);
                    contentPane.requestFocus();
                }

            }

        });
    }

    /* 1번째 키보드 리스너 */
    void key_listner1(){
        contentPane.setFocusable(true);
        contentPane.requestFocus();
        contentPane.addKeyListener(new KeyAdapter() {   //keyadapter : 하고 싶은것만 만듬

            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();   //키입력받음
                if(keyCode == KeyEvent.VK_LEFT){    //왼쪽 방향키를 누를 시
                    panel_images_card_all.panel_images_card1.cardlayout.previous(panel_images_card_all.panel_images_card1);   //컨테이너의 이전 카드를 뽑는다.
                    // 카드 안에,   0번째 카드 안에,  다시 카드의 이전                              // 부모패널
                    contentPane.setFocusable(true);
                    contentPane.requestFocus();
                }
                if(keyCode == KeyEvent.VK_RIGHT){   //오른쪽 방향키 누를 시
                    panel_images_card_all.panel_images_card1.cardlayout.next(panel_images_card_all.panel_images_card1);   //컨테이너의 다음 카드를 뽑는다.
                    contentPane.setFocusable(true);
                    contentPane.requestFocus();
                }

            }

        });
    }

    /* 2번째 키보드 리스너 */
    void key_listner2(){
        contentPane.setFocusable(true);
        contentPane.requestFocus();
        contentPane.addKeyListener(new KeyAdapter() {   //keyadapter : 하고 싶은것만 만듬

            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();   //키입력받음
                if(keyCode == KeyEvent.VK_LEFT){    //왼쪽 방향키를 누를 시
                    panel_images_card_all.panel_images_card2.cardlayout.previous(panel_images_card_all.panel_images_card2);   //컨테이너의 이전 카드를 뽑는다.
                    // 카드 안에,   0번째 카드 안에,  다시 카드의 이전                              // 부모패널
                    contentPane.setFocusable(true);
                    contentPane.requestFocus();
                }
                if(keyCode == KeyEvent.VK_RIGHT){   //오른쪽 방향키 누를 시
                    panel_images_card_all.panel_images_card2.cardlayout.next(panel_images_card_all.panel_images_card2);   //컨테이너의 다음 카드를 뽑는다.
                    contentPane.setFocusable(true);
                    contentPane.requestFocus();
                }

            }

        });
    }

    /* 3번째 키보드 리스너 */
    void key_listner3(){
        contentPane.setFocusable(true);
        contentPane.requestFocus();
        contentPane.addKeyListener(new KeyAdapter() {   //keyadapter : 하고 싶은것만 만듬

            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();   //키입력받음
                if(keyCode == KeyEvent.VK_LEFT){    //왼쪽 방향키를 누를 시
                    panel_images_card_all.panel_images_card3.cardlayout.previous(panel_images_card_all.panel_images_card3);   //컨테이너의 이전 카드를 뽑는다.
                    // 카드 안에,   0번째 카드 안에,  다시 카드의 이전                              // 부모패널
                    contentPane.setFocusable(true);
                    contentPane.requestFocus();
                }
                if(keyCode == KeyEvent.VK_RIGHT){   //오른쪽 방향키 누를 시
                    panel_images_card_all.panel_images_card3.cardlayout.next(panel_images_card_all.panel_images_card3);   //컨테이너의 다음 카드를 뽑는다.
                    contentPane.setFocusable(true);
                    contentPane.requestFocus();
                }

            }

        });
    }

    /*-------------------------------------------이미지 각각 버튼 리스너 ---------------------------------------------------------*/
    /* 0번째 이미지 페이지 6개 각각의 버튼 클릭시 리스너 */
    //이미지 각각 버튼(page0) 0 ~5 :
    void button_images_listner(){
        contentPane.setFocusable(true);
        contentPane.requestFocus();
        /* i 번째 이미지 버튼 클릭 시*/
        for(int i = 0; i<6; i++) {
            int j = i;
            /* 툴팁 삽입 : 버튼 name 배열(array_button_name)을 툴팁으로 이용한다.*/
            panel_images_card_all.panel_images_card.panel_images.button_images[i].setToolTipText(panel_images_card_all.panel_images_card.panel_images.array_button_name[j]); //툴팁으로 제목 넣기!
            panel_images_card_all.panel_images_card.panel_images.button_images[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    /* 음악 추가 */
                    panel_images_card_all.panel_images_card.panel_images.frame_music[j].setVisible(true);
//                    frame_music.loadAudio(panel_images_card_all.panel_images_card.panel_images.array_music_path[j]);   // 버튼에 음악 추가
                    label_explain.explain.setText(panel_images_card_all.panel_images_card.panel_images.array_button_name[j]);   //스트링 배열 삽입
                    contentPane.setFocusable(true); //키보드 입력을 위해 포커스를 맞춤
                    contentPane.requestFocus();
                }
            });

        }
        contentPane.setFocusable(true); //키보드 입력을 위해 포커스를 맞춤
        contentPane.requestFocus();
    }
    //이미지 각각 버튼(page)1 0~5
    void button_images_listner1(){
//        String string0, String string1, String string2, String string3, String string4, String string5
        contentPane.setFocusable(true);
        contentPane.requestFocus();
        /* i 번째 이미지 버튼 클릭 시*/
        for(int i = 0; i<6; i++) {
            int j = i;
            /* 툴팁 삽입1 : 버튼 name 배열(array_button_name)을 툴팁으로 이용한다.*/
            panel_images_card_all.panel_images_card.panel_images1.button_images1[i].setToolTipText(panel_images_card_all.panel_images_card.panel_images1.array_button_name1[j]); //툴팁으로 제목 넣기!
            panel_images_card_all.panel_images_card.panel_images1.button_images1[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    /* 음악 추가 */
                    panel_images_card_all.panel_images_card.panel_images1.frame_music[j].setVisible(true);
                    label_explain.explain.setText(panel_images_card_all.panel_images_card.panel_images1.array_button_name1[j]);   //스트링 배열 삽입
                    contentPane.setFocusable(true); //키보드 입력을 위해 포커스를 맞춤
                    contentPane.requestFocus();
                }
            });
        }
        contentPane.setFocusable(true); //키보드 입력을 위해 포커스를 맞춤
        contentPane.requestFocus();
    }



    /* 1번째 이미지 페이지 6개 각각의 버튼 클릭시 리스너 */
    //이미지 각각 버튼(page0) 0 ~5 :
    void button_images_listner_1(){
        contentPane.setFocusable(true);
        contentPane.requestFocus();
        /* i 번째 이미지 버튼 클릭 시*/
        for(int i = 0; i<6; i++) {
            int j = i;
            /* 툴팁 삽입 : 버튼 name 배열(array_button_name)을 툴팁으로 이용한다.*/
            panel_images_card_all.panel_images_card1.panel_images.button_images[i].setToolTipText(panel_images_card_all.panel_images_card1.panel_images.array_button_name[j]); //툴팁으로 제목 넣기!
            panel_images_card_all.panel_images_card1.panel_images.button_images[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    panel_images_card_all.panel_images_card1.panel_images.frame_music[j].setVisible(true);
                    label_explain.explain.setText(panel_images_card_all.panel_images_card1.panel_images.array_button_name[j]);   //스트링 배열 삽입
                    contentPane.setFocusable(true); //키보드 입력을 위해 포커스를 맞춤
                    contentPane.requestFocus();
                }
            });
        }
        contentPane.setFocusable(true); //키보드 입력을 위해 포커스를 맞춤
        contentPane.requestFocus();
    }
    //이미지 각각 버튼(page)1 0~5
    void button_images_listner1_1(){
//        String string0, String string1, String string2, String string3, String string4, String string5
        contentPane.setFocusable(true);
        contentPane.requestFocus();
        /* i 번째 이미지 버튼 클릭 시*/
        for(int i = 0; i<6; i++) {
            int j = i;
            /* 툴팁 삽입1 : 버튼 name 배열(array_button_name)을 툴팁으로 이용한다.*/
            panel_images_card_all.panel_images_card1.panel_images1.button_images1[i].setToolTipText(panel_images_card_all.panel_images_card1.panel_images1.array_button_name1[j]); //툴팁으로 제목 넣기!
            panel_images_card_all.panel_images_card1.panel_images1.button_images1[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    panel_images_card_all.panel_images_card1.panel_images1.frame_music[j].setVisible(true);
                    label_explain.explain.setText(panel_images_card_all.panel_images_card1.panel_images1.array_button_name1[j]);   //스트링 배열 삽입
                    contentPane.setFocusable(true); //키보드 입력을 위해 포커스를 맞춤
                    contentPane.requestFocus();
                }
            });
        }
        contentPane.setFocusable(true); //키보드 입력을 위해 포커스를 맞춤
        contentPane.requestFocus();
    }


    /* 2번째 이미지 페이지 6개 각각의 버튼 클릭시 리스너 */
    //이미지 각각 버튼(page0) 0 ~5 :
    void button_images_listner_2(){
        contentPane.setFocusable(true);
        contentPane.requestFocus();
        /* i 번째 이미지 버튼 클릭 시*/
        for(int i = 0; i<6; i++) {
            int j = i;
            /* 툴팁 삽입 : 버튼 name 배열(array_button_name)을 툴팁으로 이용한다.*/
            panel_images_card_all.panel_images_card2.panel_images.button_images[i].setToolTipText(panel_images_card_all.panel_images_card2.panel_images.array_button_name[j]); //툴팁으로 제목 넣기!
            panel_images_card_all.panel_images_card2.panel_images.button_images[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    panel_images_card_all.panel_images_card2.panel_images.frame_music[j].setVisible(true);
                    label_explain.explain.setText(panel_images_card_all.panel_images_card2.panel_images.array_button_name[j]);   //스트링 배열 삽입
                    contentPane.setFocusable(true); //키보드 입력을 위해 포커스를 맞춤
                    contentPane.requestFocus();
                }
            });
        }
        contentPane.setFocusable(true); //키보드 입력을 위해 포커스를 맞춤
        contentPane.requestFocus();
    }
    //이미지 각각 버튼(page)1 0~5
    void button_images_listner1_2(){
//        String string0, String string1, String string2, String string3, String string4, String string5
        contentPane.setFocusable(true);
        contentPane.requestFocus();
        /* i 번째 이미지 버튼 클릭 시*/
        for(int i = 0; i<6; i++) {
            int j = i;
            /* 툴팁 삽입1 : 버튼 name 배열(array_button_name)을 툴팁으로 이용한다.*/
            panel_images_card_all.panel_images_card2.panel_images1.button_images1[i].setToolTipText(panel_images_card_all.panel_images_card2.panel_images1.array_button_name1[j]); //툴팁으로 제목 넣기!
            panel_images_card_all.panel_images_card2.panel_images1.button_images1[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    panel_images_card_all.panel_images_card2.panel_images1.frame_music[j].setVisible(true);
                    label_explain.explain.setText(panel_images_card_all.panel_images_card2.panel_images1.array_button_name1[j]);   //스트링 배열 삽입
                    contentPane.setFocusable(true); //키보드 입력을 위해 포커스를 맞춤
                    contentPane.requestFocus();
                }
            });
        }
        contentPane.setFocusable(true); //키보드 입력을 위해 포커스를 맞춤
        contentPane.requestFocus();
    }



    /* 3번째 이미지 페이지 6개 각각의 버튼 클릭시 리스너 */
    //이미지 각각 버튼(page0) 0 ~5 :
    void button_images_listner_3(){
        contentPane.setFocusable(true);
        contentPane.requestFocus();
        /* i 번째 이미지 버튼 클릭 시*/
        for(int i = 0; i<6; i++) {
            int j = i;
            /* 툴팁 삽입 : 버튼 name 배열(array_button_name)을 툴팁으로 이용한다.*/
            panel_images_card_all.panel_images_card3.panel_images.button_images[i].setToolTipText(panel_images_card_all.panel_images_card3.panel_images.array_button_name[j]); //툴팁으로 제목 넣기!
            panel_images_card_all.panel_images_card3.panel_images.button_images[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    panel_images_card_all.panel_images_card3.panel_images.frame_music[j].setVisible(true);
                    label_explain.explain.setText(panel_images_card_all.panel_images_card3.panel_images.array_button_name[j]);   //스트링 배열 삽입
                    contentPane.setFocusable(true); //키보드 입력을 위해 포커스를 맞춤
                    contentPane.requestFocus();
                }
            });
        }
        contentPane.setFocusable(true); //키보드 입력을 위해 포커스를 맞춤
        contentPane.requestFocus();
    }
    //이미지 각각 버튼(page)1 0~5
    void button_images_listner1_3(){
//        String string0, String string1, String string2, String string3, String string4, String string5
        contentPane.setFocusable(true);
        contentPane.requestFocus();
        /* i 번째 이미지 버튼 클릭 시*/
        for(int i = 0; i<6; i++) {
            int j = i;
            /* 툴팁 삽입1 : 버튼 name 배열(array_button_name)을 툴팁으로 이용한다.*/
            panel_images_card_all.panel_images_card3.panel_images1.button_images1[i].setToolTipText(panel_images_card_all.panel_images_card3.panel_images1.array_button_name1[j]); //툴팁으로 제목 넣기!
            panel_images_card_all.panel_images_card3.panel_images1.button_images1[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    panel_images_card_all.panel_images_card3.panel_images1.frame_music[j].setVisible(true);
                    label_explain.explain.setText(panel_images_card_all.panel_images_card3.panel_images1.array_button_name1[j]);   //스트링 배열 삽입
                    contentPane.setFocusable(true); //키보드 입력을 위해 포커스를 맞춤
                    contentPane.requestFocus();
                }
            });
        }
        contentPane.setFocusable(true); //키보드 입력을 위해 포커스를 맞춤
        contentPane.requestFocus();
    }

    /*----------------------------기타 함수 -------------------------*/
    //툴팁 매니저
    void function_ToolTipManager(){
        ToolTipManager toolTipManager = ToolTipManager.sharedInstance();    //툴팁 매니저 객체 생성
        toolTipManager.setEnabled(true);    //툴팁이 보이게
        toolTipManager.setInitialDelay(1);  //마우스가 올라온 후 1ms 후에 툴팁 출력
        toolTipManager.setDismissDelay(3000);   // 툴팁이 켜져 있는 지속 시간은 3000ms로 설정 (3초)
    }

    /*팝업 다이얼로그 : 종료 버튼 클릭 시 종료하시겠습니까? */
    void function_endoption() {
        addWindowListener(new WindowAdapter() {     //윈도우 X 창 누르면
            @Override
            public void windowClosing(WindowEvent e) {
                int end_option = JOptionPane.showConfirmDialog(null, "종료하시겠습니까?", "안내", JOptionPane.YES_NO_OPTION);
                if (end_option == JOptionPane.CLOSED_OPTION) {    //사용자가 예,나 아니오 선택 없이 다이얼로그 창을 닫은 경우
                    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // DO_NOTHING_ON_CLOSE : 프레임과 창닫기 작업을 무효화
                } else if (end_option == JOptionPane.YES_OPTION) {
                    //사용자가 "예"를 선택한경우
                    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //윈도우 종료
                    super.windowClosing(e);

                } else {    // 사용자가 "아니오"를 선택한 경우
                    JOptionPane.showMessageDialog(null, "취소되었습니다.", "안내", JOptionPane.ERROR_MESSAGE);   //팝업창 띄우고
                    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);   //윈도우 종료 안시킴 :DO_NOTHING_ON_CLOSE : 프레임과 창닫기 작업을 무효화
                }
            }
        });
    }
}

