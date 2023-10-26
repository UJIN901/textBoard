package com.ll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    int quotationId;
    Scanner scanner;
    List<Quotation> quotations;
    App(){
        quotationId = 0;
        scanner = new Scanner(System.in);
        quotations = new ArrayList<>();

    }
    void run() {
        System.out.println("== 명언 앱 ==");

        while (true) {
            System.out.print("명령) ");
            String cmd = scanner.nextLine();

            if (cmd.equals("종료")) {
                break;
            } else if (cmd.equals("등록")){
                actionWrite();
            } else if(cmd.equals("목록")){
                actionList();
            }
        }

    }
    void actionWrite(){
        System.out.print("명언 : ");
        String text = scanner.nextLine();
        System.out.print("작가 : ");
        String author = scanner.nextLine();
        quotationId++;
        Quotation quotation = new Quotation(quotationId, text, author);
        quotations.add(quotation);
        System.out.printf("%d번 명언이 등록되었습니다.\n", quotationId);
    }
    void actionList(){

        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");
        if(quotationId == 0){
            System.out.println("등록된 명언이 없습니다.");
        } else {
            for (int i = quotations.size(); i > 0; i--){
                Quotation quotation = quotations.get(i-1);
                System.out.printf("%d / %s / %s\n", quotation.id, quotation.author, quotation.text);
            }
        }
    }
}