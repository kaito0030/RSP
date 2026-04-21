package View;

public class NumToKansuji {
	private static String[] kanji = {"〇", "一", "二", "三", "四", "五", "六", "七", "八", "九"};
	private static  String[]oza = {"〇", "壱", "弐", "参", "肆", "伍", "陸", "漆", "捌", "玖"};

    public static String convert(int num,boolean flag) {
    		

        String s = String.valueOf(num);
        StringBuilder sb = new StringBuilder();
		if(!flag) {
	        for (int i = 0; i < s.length(); i++) {
	            sb.append(kanji[s.charAt(i) - '0']);
	        }
		}else {
	        for (int i = 0; i < s.length(); i++) {
	            sb.append(oza[s.charAt(i) - '0']);
	        }
		}

        return sb.toString();
    }

}