package loop;

import java.util.Scanner;

/*
* 문제
준원이는 저번 주에 살면서 처음으로 코스트코를 가 봤다. 정말 멋졌다. 그런데, 몇 개 담지도 않았는데 수상하게 높은 금액이 나오는 것이다! 준원이는 영수증을 보면서 정확하게 계산된 것이 맞는지 확인해보려 한다.

영수증에 적힌,

구매한 각 물건의 가격과 개수
구매한 물건들의 총 금액
을 보고, 구매한 물건의 가격과 개수로 계산한 총 금액이 영수증에 적힌 총 금액과 일치하는지 검사해보자.

입력
첫째 줄에는 영수증에 적힌 총 금액
$X$가 주어진다.

둘째 줄에는 영수증에 적힌 구매한 물건의 종류의 수
$N$이 주어진다.

이후
$N$개의 줄에는 각 물건의 가격
$a$와 개수
$b$가 공백을 사이에 두고 주어진다.

출력
구매한 물건의 가격과 개수로 계산한 총 금액이 영수증에 적힌 총 금액과 일치하면 Yes를 출력한다. 일치하지 않는다면 No를 출력한다.
* */
public class loop25304 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int total = scanner.nextInt();
        int cnt = scanner.nextInt();

        Item[] items = new Item[cnt];
        for (int i = 0; i < cnt; i++) {
            int price = scanner.nextInt();
            int quantity = scanner.nextInt();
            items[i] = new Item(price, quantity);
        }

        scanner.close();

        if (isReceiptValid(total, items)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    private static boolean isReceiptValid(int total, Item[] items) {
        int calculatedTotal = 0;
        for (Item item : items) {
            calculatedTotal += item.getTotalPrice();
        }
        return calculatedTotal == total;
    }
}

class Item {
    int price;
    int quantity;

    public Item(int price, int quantity) {
        this.price = price;
        this.quantity = quantity;
    }

    public int getTotalPrice() {
        return price * quantity;
    }
}

