package frame;

import java.util.ArrayList;

public class BookDAO {
	private static ArrayList<Book> list1;
	private static ArrayList<Book> list2;

	public BookDAO() {

		if (list1 == null) {
			init1();
		}

		if (list2 == null) {
			init2();
		}
	}

	private void init1() {

		list1 = new ArrayList<Book>();

		list1.add(new Book("무지개 물고기", "시공주니어", "마르쿠스 피스터", "바닷속에 알록달록 무지개빛깔 비늘을 가진 물고기가 있다!\r\n이 물고기에게 고민이 있다는데 무엇일까?",
				"<html><br>무지개 물고기는 산호초 아저씨를 <br>찾아갔습니다.<html>", "<html><br>무지개 물고기는 하루에 한 번 <br>무지개를 만듭니다.<html>", "<html><br>무지개 물고기는 친구들에게 <br>비늘을 나눠주었습니다.<html>", "X", "X",
				"O"));

		list1.add(new Book("흥부와 놀부", "지경사", "강원희", "가난한 동생 흥부와 부잣집 형인 놀부\r\n이들은 같은 부모 밑에서 태어났건만 어쩌다 이렇게?!",
				"<html><br>놀부는 까마귀 다리를 고쳐주고 <br>박을 얻었습니다.<html>", "<html><br>흥부의 자식은 1명 입니다.<br><html>",  "<html><br>흥부는 박을 타서 금은보화를 얻었습니다.<br><html>", "X", "X", "O"));

		list1.add(new Book("누가 내 머리에 똥 쌌어?", "사계절", "베르너 훌츠바르트", "누군가 두더지의 머리 위에 똥을 쌌다! 과연 범인은 누구일까?!",
				"<html><br>이 책의 주인공은 두더지입니다.<html>", "<html><br>두더지는 머리에 똥 싼 범인을 <br>찾기 위해 뱀에게 물어봤습니다.<html>", "<html><br>두더지는 파리의 도움으로 <br>똥 싼 범인을 찾게 됩니다.<html>", "O", "X",
				"O"));

		list1.add(new Book("아기돼지 삼형제", "애플비북스", "이지수", "집에서 독립했지만 바깥은 위험하다! 아기돼지 삼형제는 어떻게 바깥의 위험으로부터 자신의 몸을 지킬 것인가!",
				"<html><br>첫째 돼지는 벽돌로 집을 지었습니다.<html>", "<html><br>둘째 돼지의 집을 부순건 코끼리입니다.<html>", "<html><br>둘째돼지와 셋째돼지는<br> 늑대에게 잡아먹혔습니다.<html>", "X", "X", "X"));
	} // ini1() 8~10세 도서

	private void init2() {

		list2 = new ArrayList<Book>();

		list2.add(new Book("어린왕자", "열린책들", "앙투안 드 생택쥐페리",
				"어린 왕자가 겪은 다양한 별들의 모험!\r\n이 책에는 여우와의 일화가 가장 유명하다는데..\r\n무슨 이야기일까?", "<html><br>어린왕자는 여우에게 양을 <br>그려달라고 부탁합니다.<html>",
				"<html><br>어린왕자는 가로등을 켜는 사람(점등인)을 <br>바보같다고 놀립니다.<html>", "<html><br>장미꽃은 어린왕자를 대하는 것에 <br>서툴러했습니다.<html>", "X", "X", "O"));

		list2.add(new Book("책 먹는 여우", "주니어 김영사", "프란치스카 비어만",
				"책이 너무너무 좋은 여우 아저씨.\r\n이 아저씨는 책을 너무 좋아한 나머지 감옥까지 간다구!?", "<html><br>여우 아저씨는 책을 먹는걸 좋아합니다.<html>",
				"<html><br>여우 아저씨는 도서관 책을 먹어서 <br>사람들에게 칭찬을 들었습니다.<html>", "<html><br>여우 아저씨는 베스트셀러 작가가 <br>되는게 꿈이었습니다.<html>", "O", "X", "X"));

		list2.add(new Book("이상한 나라의 앨리스", "연초록", "루이스 캐럴", "앨리스가 겪는 기묘한 모험!\r\n어떻게 토끼가 말을?!",
				"<html><br>앨리스가 토끼굴로 떨어지게 된 <br>계기는 앨리스의 꿈이었다.<html>", "<html><br>이상한 나라의 여왕이 좋아하는 <br>카드 게임은 포커입니다.<html>",
				"<html><br>앨리스가 이상한 나라에서 크기를 <br>조절할 수 있는 물건은 초콜릿입니다.<html>", "O", "O", "X"));

		list2.add(new Book("아낌없이 주는 나무", "시공주니어", "쉘 실버스타인", "나무와 소년의 인생 이야기!\r\n이 책의 진짜 의미는 무엇일까 생각해보자.",
				"<html><br>소년은 나무의 사과를 팔아<br> 돈을 벌었습니다.<html>", "<html><br>소년은 나무 그네 타는 것을 <br>싫어했습니다.<html>", "<html><br>나무는 소년이 점점 싫어졌습니다.<html>", "O", "X", "X"));
	} // init2() 11~13세 도서

	public Book searchBook1(String name) {

		for (int i = 0; i < list1.size(); i++) {

			if (list1.get(i).getBookName().equals(name)) {

				return list1.get(i);
			}
		}
		return null;
	}

	public Book searchBook2(String name) {

		for (int i = 0; i < list2.size(); i++) {

			if (list2.get(i).getBookName().equals(name)) {

				return list2.get(i);
			}
		}
		return null;
	}

}