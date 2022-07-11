package poly.util;

import java.util.ArrayList;
import java.util.List;

public class MbtiUtil {
	public static List<String> getAnalysis(String my_mbti, List<List<String>> mLists) throws Exception {

		// 리스트형태로 점수를 내보내기위함
		List<String> mbti_scores = new ArrayList<String>();

		try {
			int mbti_avg = 0;
			int score = 0;

			for (List<String> mbtis : mLists) {
				//////////////////////////////////////////////////
				for (String mbti : mbtis) {
					System.out.println("my_mbti : " + my_mbti);
					System.out.println("mbti : " + mbti);
					if (my_mbti.equals("ENTJ")) {
						if (mbti.equals("ENTJ") || mbti.equals("ESFJ") || mbti.equals("ISFJ")) {
							// 맞지않는 유형
							score += 1;
						} else if (mbti.equals("ENTP") || mbti.equals("ENTP") || mbti.equals("ISTJ")
								|| mbti.equals("ENFJ")) {
							// 갈등 관계
							score += 3;
						} else if (mbti.equals("INTJ") || mbti.equals("INTP") || mbti.equals("ENFP")
								|| mbti.equals("INFJ") || mbti.equals("ISTP")) {
							// 잠재적 관계
							score += 3;
						} else if (mbti.equals("ESTP") || mbti.equals("ESFP")) {
							// 끈끈한 관계
							score += 5;
						} else if (mbti.equals("INFP") || mbti.equals("ISFP")) {
							// 이상적인관계
							score += 5;
						} else {
							score += 1;
						}
					} else if (my_mbti.equals("ENTP")) {
						if (mbti.equals("ESFP") || mbti.equals("ISFP")) {
							// 맞지않는 유형
							score += 1;
						} else if (mbti.equals("ENTJ") || mbti.equals("ENFP") || mbti.equals("ESTP")
								|| mbti.equals("ISTP")) {
							// 갈등 관계
							score += 3;
						} else if (mbti.equals("INTJ") || mbti.equals("INTP") || mbti.equals("ENFJ")
								|| mbti.equals("INFJ") || mbti.equals("INFP")) {
							// 잠재적 관계
							score += 3;
						} else if (mbti.equals("ENTP") || mbti.equals("ENTP") || mbti.equals("ESFJ")) {
							// 끈끈한 관계
							score += 5;
						} else if (mbti.equals("ISTJ") || mbti.equals("ISFJ")) {
							// 이상적인관계
							score += 5;
						} else {
							score += 1;
						}
					} else if (my_mbti.equals("INTJ")) {
						if (mbti.equals("ESFJ") || mbti.equals("ISFJ")) {
							// 맞지않는 유형
							score += 1;
						} else if (mbti.equals("INTP") || mbti.equals("ENTP")) {
							// 갈등 관계
							score += 3;
						} else if (mbti.equals("ENTJ") || mbti.equals("ENTP") || mbti.equals("INTJ")
								|| mbti.equals("ISTJ") || mbti.equals("ENFJ") || mbti.equals("ENFP")
								|| mbti.equals("INFJ") || mbti.equals("ISTP")) {
							// 잠재적 관계
							score += 3;
						} else if (mbti.equals("INFP") || mbti.equals("ISFP")) {
							// 끈끈한 관계
							score += 5;
						} else if (mbti.equals("ESTP") || mbti.equals("ESFP")) {
							// 이상적인관계
							score += 5;
						} else {
							score += 1;
						}
					} else if (my_mbti.equals("INTP")) {
						if (mbti.equals("ESFP") || mbti.equals("ISFP")) {
							// 맞지않는 유형
							score += 1;
						} else if (mbti.equals("INTJ") || mbti.equals("INFP") || mbti.equals("ESTP")
								|| mbti.equals("ISTP")) {
							// 갈등 관계
							score += 3;
						} else if (mbti.equals("ENTJ") || mbti.equals("ENTP") || mbti.equals("INTP")
								|| mbti.equals("ISTJ") || mbti.equals("ENFP")) {
							// 잠재적 관계
							score += 3;
						} else if (mbti.equals("ENTP") || mbti.equals("INFJ")) {
							// 끈끈한 관계
							score += 5;
						} else if (mbti.equals("ESFJ") || mbti.equals("ISFJ") || mbti.equals("ENFJ")) {
							// 이상적인관계
							score += 5;
						} else {
							score += 1;
						}
					} else if (my_mbti.equals("ENTP")) {
						if (mbti.equals("ENFJ") || mbti.equals("INFJ") || mbti.equals("ESTP")) {
							// 맞지않는 유형
							score += 1;
						} else if (mbti.equals("ENTJ") || mbti.equals("INTJ") || mbti.equals("ESFJ")) {
							// 갈등 관계
							score += 3;
						} else if (mbti.equals("ENTP") || mbti.equals("ISTJ") || mbti.equals("ISFJ")
								|| mbti.equals("ENFP") || mbti.equals("ESFP") || mbti.equals("ISTP")) {
							// 잠재적 관계
							score += 3;
						} else if (mbti.equals("ENTP") || mbti.equals("INTP")) {
							// 끈끈한 관계
							score += 5;
						} else if (mbti.equals("INFP") || mbti.equals("ISFP")) {
							// 이상적인관계
							score += 5;
						} else {
							score += 1;
						}
					} else if (my_mbti.equals("ESFJ")) {
						if (mbti.equals("ENTJ") || mbti.equals("INTJ")) {
							// 맞지않는 유형
							score += 1;
						} else if (mbti.equals("ENTP") || mbti.equals("INFJ") || mbti.equals("ESFP")) {
							// 갈등 관계
							score += 3;
						} else if (mbti.equals("ESFJ") || mbti.equals("ISTJ") || mbti.equals("ISFJ")
								|| mbti.equals("ENFJ") || mbti.equals("INFP") || mbti.equals("ESTP")
								|| mbti.equals("ISFP")) {
							// 잠재적 관계
							score += 3;
						} else if (mbti.equals("ENTP") || mbti.equals("ENFP")) {
							// 끈끈한 관계
							score += 5;
						} else if (mbti.equals("INTP") || mbti.equals("ISTP")) {
							// 이상적인관계
							score += 5;
						} else {
							score += 1;
						}
					} else if (my_mbti.equals("ISTJ")) {
						if (mbti.equals("ENFJ") || mbti.equals("INFJ")) {
							// 맞지않는 유형
							score += 1;
						} else if (mbti.equals("ENTJ") || mbti.equals("ISFJ") || mbti.equals("ISTP")) {
							// 갈등 관계
							score += 3;
						} else if (mbti.equals("INTJ") || mbti.equals("INTP") || mbti.equals("ENTP")
								|| mbti.equals("ESFJ") || mbti.equals("ISTJ") || mbti.equals("ESTP")
								|| mbti.equals("ESFP")) {
							// 잠재적 관계
							score += 3;
						} else if (mbti.equals("ISTP")) {
							// 끈끈한 관계
							score += 5;
						} else if (mbti.equals("ENTP") || mbti.equals("INTP") || mbti.equals("ENFP")) {
							// 이상적인관계
							score += 5;
						} else {
							score += 1;
						}
					} else if (my_mbti.equals("ISFJ")) {
						if (mbti.equals("ENTJ") || mbti.equals("INTJ") || mbti.equals("ISFP")) {
							// 맞지않는 유형
							score += 1;
						} else if (mbti.equals("ISTJ") || mbti.equals("ISFJ") || mbti.equals("ENFJ")
								|| mbti.equals("INFJ")) {
							// 갈등 관계
							score += 3;
						} else if (mbti.equals("ENTP") || mbti.equals("ESFJ") || mbti.equals("INFP")
								|| mbti.equals("ESTP") || mbti.equals("ESFP")) {
							// 잠재적 관계
							score += 3;
						} else if (mbti.equals("ISTP")) {
							// 끈끈한 관계
							score += 5;
						} else if (mbti.equals("ENTP") || mbti.equals("INTP") || mbti.equals("ENFP")) {
							// 이상적인관계
							score += 5;
						} else {
							score += 1;
						}
					} else if (my_mbti.equals("ENFJ")) {
						if (mbti.equals("ENTP") || mbti.equals("ISTJ")) {
							// 맞지않는 유형
							score += 1;
						} else if (mbti.equals("ENTJ") || mbti.equals("ISFJ") || mbti.equals("ENFP")) {
							// 갈등 관계
							score += 3;
						} else if (mbti.equals("ENTP") || mbti.equals("INTJ") || mbti.equals("ESFJ")
								|| mbti.equals("INFJ") || mbti.equals("INFP") || mbti.equals("ISFP")) {
							// 잠재적 관계
							score += 3;
						} else if (mbti.equals("ENFJ") || mbti.equals("ESTP") || mbti.equals("ESFP")) {
							// 끈끈한 관계
							score += 5;
						} else if (mbti.equals("INTP") || mbti.equals("ISTP")) {
							// 이상적인관계4
							score += 5;
						} else {
							score += 1;
						}
					} else if (my_mbti.equals("ENFP")) {
						if (mbti.equals("ESTP") || mbti.equals("ESFP") || mbti.equals("ISTP")) {
							// 맞지않는 유형
							score += 1;
						} else if (mbti.equals("ENTP") || mbti.equals("ENFJ") || mbti.equals("INFP")) {
							// 갈등 관계
							score += 3;
						} else if (mbti.equals("ENTJ") || mbti.equals("INTJ") || mbti.equals("INTP")
								|| mbti.equals("ENFP") || mbti.equals("INFJ") || mbti.equals("ISFP")) {
							// 잠재적 관계
							score += 3;
						} else if (mbti.equals("ENTP") || mbti.equals("ESFJ")) {
							// 끈끈한 관계
							score += 5;
						} else if (mbti.equals("ISTJ") || mbti.equals("ISFJ")) {
							// 이상적인관계
							score += 5;
						} else {
							score += 1;
						}
					} else if (my_mbti.equals("INFJ")) {
						if (mbti.equals("ENTP") || mbti.equals("ISTJ") || mbti.equals("INFP")) {
							// 맞지않는 유형
							score += 1;
						} else if (mbti.equals("ESFJ") || mbti.equals("ISFJ")) {
							// 갈등 관계
							score += 3;
						} else if (mbti.equals("ENTJ") || mbti.equals("ENTP") || mbti.equals("INTJ")
								|| mbti.equals("ENFJ") || mbti.equals("ENFP") || mbti.equals("INFJ")
								|| mbti.equals("ISFP")) {
							// 잠재적 관계
							score += 3;
						} else if (mbti.equals("INTP")) {
							// 끈끈한 관계
							score += 5;
						} else if (mbti.equals("ESTP") || mbti.equals("ESFP") || mbti.equals("ISTP")) {
							// 이상적인관계
							score += 5;
						} else {
							score += 1;
						}
					} else if (my_mbti.equals("INFP")) {
						if (mbti.equals("INFJ") || mbti.equals("ESTP")) {
							// 맞지않는 유형
							score += 1;
						} else if (mbti.equals("INTP") || mbti.equals("ENFP") || mbti.equals("ESFP")
								|| mbti.equals("ISTP") || mbti.equals("ISFP")) {
							// 갈등 관계
							score += 3;
						} else if (mbti.equals("ENTP") || mbti.equals("ESFJ") || mbti.equals("ISFJ")
								|| mbti.equals("ENFJ") || mbti.equals("INFP")) {
							// 잠재적 관계
							score += 3;
						} else if (mbti.equals("INTJ") || mbti.equals("ISTJ")) {
							// 끈끈한 관계
							score += 5;
						} else if (mbti.equals("ENTJ") || mbti.equals("ENTP")) {
							// 이상적인관계
							score += 5;
						} else {
							score += 1;
						}
					} else if (my_mbti.equals("ESTP")) {
						if (mbti.equals("ENTP") || mbti.equals("ENFP") || mbti.equals("INFP")) {
							// 맞지않는 유형
							score += 1;
						} else if (mbti.equals("ENTP") || mbti.equals("INTP") || mbti.equals("ESFP")) {
							// 갈등 관계
							score += 3;
						} else if (mbti.equals("ESFJ") || mbti.equals("ISTJ") || mbti.equals("ISFJ")
								|| mbti.equals("ESTP") || mbti.equals("ISTP") || mbti.equals("ISFP")) {
							// 잠재적 관계
							score += 3;
						} else if (mbti.equals("ENTJ") || mbti.equals("ENFJ")) {
							// 끈끈한 관계
							score += 5;
						} else if (mbti.equals("INTJ") || mbti.equals("INFJ")) {
							// 이상적인관계
							score += 5;
						} else {
							score += 1;
						}
					} else if (my_mbti.equals("ESFP")) {
						if (mbti.equals("ENTP") || mbti.equals("INTP") || mbti.equals("ISFJ")) {
							// 맞지않는 유형
							score += 1;
						} else if (mbti.equals("ESFJ") || mbti.equals("INFP") || mbti.equals("ESTP")
								|| mbti.equals("ESFP")) {
							// 갈등 관계
							score += 3;
						} else if (mbti.equals("ENTP") || mbti.equals("ISTJ") || mbti.equals("ISFJ")
								|| mbti.equals("ISTP") || mbti.equals("ISFP")) {
							// 잠재적 관계
							score += 3;
						} else if (mbti.equals("ENTJ") || mbti.equals("ENFJ")) {
							// 끈끈한 관계
							score += 5;
						} else if (mbti.equals("INTJ") || mbti.equals("INFJ")) {
							// 이상적인관계
							score += 5;
						} else {
							score += 1;
						}
					} else if (my_mbti.equals("ISTP")) {
						if (mbti.equals("ENFP") || mbti.equals("INFP")) {
							// 맞지않는 유형
							score += 1;
						} else if (mbti.equals("ENTP") || mbti.equals("INTP") || mbti.equals("ISTJ")
								|| mbti.equals("ISTP") || mbti.equals("ISFP")) {
							// 갈등 관계
							score += 3;
						} else if (mbti.equals("ENTJ") || mbti.equals("INTJ") || mbti.equals("ENTP")
								|| mbti.equals("ESTP") || mbti.equals("ESFP")) {
							// 잠재적 관계
							score += 3;
						} else if (mbti.equals("ISFJ")) {
							// 끈끈한 관계
							score += 5;
						} else if (mbti.equals("ESFJ") || mbti.equals("ENFJ") || mbti.equals("INFJ")) {
							// 이상적인관계
							score += 5;
						} else {
							score += 1;
						}
					} else if (my_mbti.equals("ISFP")) {
						if (mbti.equals("ENTP") || mbti.equals("INTP") || mbti.equals("ISFJ")) {
							// 맞지않는 유형
							score += 1;
						} else if (mbti.equals("INFP") || mbti.equals("ISTP")) {
							// 갈등 관계
							score += 3;
						} else if (mbti.equals("ESFJ") || mbti.equals("ENFJ") || mbti.equals("ENFP")
								|| mbti.equals("INFJ") || mbti.equals("ESTP") || mbti.equals("ESFP")
								|| mbti.equals("ISFP")) {
							// 잠재적 관계
							score += 3;
						} else if (mbti.equals("INTJ") || mbti.equals("ISTJ")) {
							// 끈끈한 관계
							score += 5;
						} else if (mbti.equals("ENTJ") || mbti.equals("ENTP")) {
							// 이상적인관계
							score += 5;
						} else {
							score += 1;
						}
					}
				}
				/////////////////////////////////////////////////
				// 하나의 스터디그룹의 멤버 MBTI 확인끝
				// 스터디의 멤버들의 MBTI를 모두 확인하였으면 List에 점수를 담음
				System.out.println("score : " + score);
				mbti_avg = score / (mbtis.size());
				mbti_scores.add(String.valueOf(mbti_avg));
				score = 0;
				mbti_avg = 0;
			} // 모든 스터디그룹의 멤버 MBTI 확인끝

		} catch (Exception e) {
			e.printStackTrace();
		}

		return mbti_scores;

	}

	public static int getStudyAnalysis(String my_mbti, List<String> mList) {
		int mbti_avg = 0;
		int score = 0;
		
		try {
			for (String mbti : mList) {

				if (my_mbti.equals("ENTJ")) {
					if (mbti.equals("ENTJ") || mbti.equals("ESFJ") || mbti.equals("ISFJ")) {
						// 맞지않는 유형
						score += 1;
					} else if (mbti.equals("ENTP") || mbti.equals("ENTP") || mbti.equals("ISTJ")
							|| mbti.equals("ENFJ")) {
						// 갈등 관계
						score += 3;
					} else if (mbti.equals("INTJ") || mbti.equals("INTP") || mbti.equals("ENFP") || mbti.equals("INFJ")
							|| mbti.equals("ISTP")) {
						// 잠재적 관계
						score += 3;
					} else if (mbti.equals("ESTP") || mbti.equals("ESFP")) {
						// 끈끈한 관계
						score += 5;
					} else if (mbti.equals("INFP") || mbti.equals("ISFP")) {
						// 이상적인관계
						score += 5;
					} else {
						score += 1;
					}
				} else if (my_mbti.equals("ENTP")) {
					if (mbti.equals("ESFP") || mbti.equals("ISFP")) {
						// 맞지않는 유형
						score += 1;
					} else if (mbti.equals("ENTJ") || mbti.equals("ENFP") || mbti.equals("ESTP")
							|| mbti.equals("ISTP")) {
						// 갈등 관계
						score += 3;
					} else if (mbti.equals("INTJ") || mbti.equals("INTP") || mbti.equals("ENFJ") || mbti.equals("INFJ")
							|| mbti.equals("INFP")) {
						// 잠재적 관계
						score += 3;
					} else if (mbti.equals("ENTP") || mbti.equals("ENTP") || mbti.equals("ESFJ")) {
						// 끈끈한 관계
						score += 5;
					} else if (mbti.equals("ISTJ") || mbti.equals("ISFJ")) {
						// 이상적인관계
						score += 5;
					} else {
						score += 1;
					}
				} else if (my_mbti.equals("INTJ")) {
					if (mbti.equals("ESFJ") || mbti.equals("ISFJ")) {
						// 맞지않는 유형
						score += 1;
					} else if (mbti.equals("INTP") || mbti.equals("ENTP")) {
						// 갈등 관계
						score += 3;
					} else if (mbti.equals("ENTJ") || mbti.equals("ENTP") || mbti.equals("INTJ") || mbti.equals("ISTJ")
							|| mbti.equals("ENFJ") || mbti.equals("ENFP") || mbti.equals("INFJ")
							|| mbti.equals("ISTP")) {
						// 잠재적 관계
						score += 3;
					} else if (mbti.equals("INFP") || mbti.equals("ISFP")) {
						// 끈끈한 관계
						score += 5;
					} else if (mbti.equals("ESTP") || mbti.equals("ESFP")) {
						// 이상적인관계
						score += 5;
					} else {
						score += 1;
					}
				} else if (my_mbti.equals("INTP")) {
					if (mbti.equals("ESFP") || mbti.equals("ISFP")) {
						// 맞지않는 유형
						score += 1;
					} else if (mbti.equals("INTJ") || mbti.equals("INFP") || mbti.equals("ESTP")
							|| mbti.equals("ISTP")) {
						// 갈등 관계
						score += 3;
					} else if (mbti.equals("ENTJ") || mbti.equals("ENTP") || mbti.equals("INTP") || mbti.equals("ISTJ")
							|| mbti.equals("ENFP")) {
						// 잠재적 관계
						score += 3;
					} else if (mbti.equals("ENTP") || mbti.equals("INFJ")) {
						// 끈끈한 관계
						score += 5;
					} else if (mbti.equals("ESFJ") || mbti.equals("ISFJ") || mbti.equals("ENFJ")) {
						// 이상적인관계
						score += 5;
					} else {
						score += 1;
					}
				} else if (my_mbti.equals("ENTP")) {
					if (mbti.equals("ENFJ") || mbti.equals("INFJ") || mbti.equals("ESTP")) {
						// 맞지않는 유형
						score += 1;
					} else if (mbti.equals("ENTJ") || mbti.equals("INTJ") || mbti.equals("ESFJ")) {
						// 갈등 관계
						score += 3;
					} else if (mbti.equals("ENTP") || mbti.equals("ISTJ") || mbti.equals("ISFJ") || mbti.equals("ENFP")
							|| mbti.equals("ESFP") || mbti.equals("ISTP")) {
						// 잠재적 관계
						score += 3;
					} else if (mbti.equals("ENTP") || mbti.equals("INTP")) {
						// 끈끈한 관계
						score += 5;
					} else if (mbti.equals("INFP") || mbti.equals("ISFP")) {
						// 이상적인관계
						score += 5;
					} else {
						score += 1;
					}
				} else if (my_mbti.equals("ESFJ")) {
					if (mbti.equals("ENTJ") || mbti.equals("INTJ")) {
						// 맞지않는 유형
						score += 1;
					} else if (mbti.equals("ENTP") || mbti.equals("INFJ") || mbti.equals("ESFP")) {
						// 갈등 관계
						score += 3;
					} else if (mbti.equals("ESFJ") || mbti.equals("ISTJ") || mbti.equals("ISFJ") || mbti.equals("ENFJ")
							|| mbti.equals("INFP") || mbti.equals("ESTP") || mbti.equals("ISFP")) {
						// 잠재적 관계
						score += 3;
					} else if (mbti.equals("ENTP") || mbti.equals("ENFP")) {
						// 끈끈한 관계
						score += 5;
					} else if (mbti.equals("INTP") || mbti.equals("ISTP")) {
						// 이상적인관계
						score += 5;
					} else {
						score += 1;
					}
				} else if (my_mbti.equals("ISTJ")) {
					if (mbti.equals("ENFJ") || mbti.equals("INFJ")) {
						// 맞지않는 유형
						score += 1;
					} else if (mbti.equals("ENTJ") || mbti.equals("ISFJ") || mbti.equals("ISTP")) {
						// 갈등 관계
						score += 3;
					} else if (mbti.equals("INTJ") || mbti.equals("INTP") || mbti.equals("ENTP") || mbti.equals("ESFJ")
							|| mbti.equals("ISTJ") || mbti.equals("ESTP") || mbti.equals("ESFP")) {
						// 잠재적 관계
						score += 3;
					} else if (mbti.equals("ISTP")) {
						// 끈끈한 관계
						score += 5;
					} else if (mbti.equals("ENTP") || mbti.equals("INTP") || mbti.equals("ENFP")) {
						// 이상적인관계
						score += 5;
					} else {
						score += 1;
					}
				} else if (my_mbti.equals("ISFJ")) {
					if (mbti.equals("ENTJ") || mbti.equals("INTJ") || mbti.equals("ISFP")) {
						// 맞지않는 유형
						score += 1;
					} else if (mbti.equals("ISTJ") || mbti.equals("ISFJ") || mbti.equals("ENFJ")
							|| mbti.equals("INFJ")) {
						// 갈등 관계
						score += 3;
					} else if (mbti.equals("ENTP") || mbti.equals("ESFJ") || mbti.equals("INFP") || mbti.equals("ESTP")
							|| mbti.equals("ESFP")) {
						// 잠재적 관계
						score += 3;
					} else if (mbti.equals("ISTP")) {
						// 끈끈한 관계
						score += 5;
					} else if (mbti.equals("ENTP") || mbti.equals("INTP") || mbti.equals("ENFP")) {
						// 이상적인관계
						score += 5;
					} else {
						score += 1;
					}
				} else if (my_mbti.equals("ENFJ")) {
					if (mbti.equals("ENTP") || mbti.equals("ISTJ")) {
						// 맞지않는 유형
						score += 1;
					} else if (mbti.equals("ENTJ") || mbti.equals("ISFJ") || mbti.equals("ENFP")) {
						// 갈등 관계
						score += 3;
					} else if (mbti.equals("ENTP") || mbti.equals("INTJ") || mbti.equals("ESFJ") || mbti.equals("INFJ")
							|| mbti.equals("INFP") || mbti.equals("ISFP")) {
						// 잠재적 관계
						score += 3;
					} else if (mbti.equals("ENFJ") || mbti.equals("ESTP") || mbti.equals("ESFP")) {
						// 끈끈한 관계
						score += 5;
					} else if (mbti.equals("INTP") || mbti.equals("ISTP")) {
						// 이상적인관계4
						score += 5;
					} else {
						score += 1;
					}
				} else if (my_mbti.equals("ENFP")) {
					if (mbti.equals("ESTP") || mbti.equals("ESFP") || mbti.equals("ISTP")) {
						// 맞지않는 유형
						score += 1;
					} else if (mbti.equals("ENTP") || mbti.equals("ENFJ") || mbti.equals("INFP")) {
						// 갈등 관계
						score += 3;
					} else if (mbti.equals("ENTJ") || mbti.equals("INTJ") || mbti.equals("INTP") || mbti.equals("ENFP")
							|| mbti.equals("INFJ") || mbti.equals("ISFP")) {
						// 잠재적 관계
						score += 3;
					} else if (mbti.equals("ENTP") || mbti.equals("ESFJ")) {
						// 끈끈한 관계
						score += 5;
					} else if (mbti.equals("ISTJ") || mbti.equals("ISFJ")) {
						// 이상적인관계
						score += 5;
					} else {
						score += 1;
					}
				} else if (my_mbti.equals("INFJ")) {
					if (mbti.equals("ENTP") || mbti.equals("ISTJ") || mbti.equals("INFP")) {
						// 맞지않는 유형
						score += 1;
					} else if (mbti.equals("ESFJ") || mbti.equals("ISFJ")) {
						// 갈등 관계
						score += 3;
					} else if (mbti.equals("ENTJ") || mbti.equals("ENTP") || mbti.equals("INTJ") || mbti.equals("ENFJ")
							|| mbti.equals("ENFP") || mbti.equals("INFJ") || mbti.equals("ISFP")) {
						// 잠재적 관계
						score += 3;
					} else if (mbti.equals("INTP")) {
						// 끈끈한 관계
						score += 5;
					} else if (mbti.equals("ESTP") || mbti.equals("ESFP") || mbti.equals("ISTP")) {
						// 이상적인관계
						score += 5;
					} else {
						score += 1;
					}
				} else if (my_mbti.equals("INFP")) {
					if (mbti.equals("INFJ") || mbti.equals("ESTP")) {
						// 맞지않는 유형
						score += 1;
					} else if (mbti.equals("INTP") || mbti.equals("ENFP") || mbti.equals("ESFP") || mbti.equals("ISTP")
							|| mbti.equals("ISFP")) {
						// 갈등 관계
						score += 3;
					} else if (mbti.equals("ENTP") || mbti.equals("ESFJ") || mbti.equals("ISFJ") || mbti.equals("ENFJ")
							|| mbti.equals("INFP")) {
						// 잠재적 관계
						score += 3;
					} else if (mbti.equals("INTJ") || mbti.equals("ISTJ")) {
						// 끈끈한 관계
						score += 5;
					} else if (mbti.equals("ENTJ") || mbti.equals("ENTP")) {
						// 이상적인관계
						score += 5;
					} else {
						score += 1;
					}
				} else if (my_mbti.equals("ESTP")) {
					if (mbti.equals("ENTP") || mbti.equals("ENFP") || mbti.equals("INFP")) {
						// 맞지않는 유형
						score += 1;
					} else if (mbti.equals("ENTP") || mbti.equals("INTP") || mbti.equals("ESFP")) {
						// 갈등 관계
						score += 3;
					} else if (mbti.equals("ESFJ") || mbti.equals("ISTJ") || mbti.equals("ISFJ") || mbti.equals("ESTP")
							|| mbti.equals("ISTP") || mbti.equals("ISFP")) {
						// 잠재적 관계
						score += 3;
					} else if (mbti.equals("ENTJ") || mbti.equals("ENFJ")) {
						// 끈끈한 관계
						score += 5;
					} else if (mbti.equals("INTJ") || mbti.equals("INFJ")) {
						// 이상적인관계
						score += 5;
					} else {
						score += 1;
					}
				} else if (my_mbti.equals("ESFP")) {
					if (mbti.equals("ENTP") || mbti.equals("INTP") || mbti.equals("ISFJ")) {
						// 맞지않는 유형
						score += 1;
					} else if (mbti.equals("ESFJ") || mbti.equals("INFP") || mbti.equals("ESTP")
							|| mbti.equals("ESFP")) {
						// 갈등 관계
						score += 3;
					} else if (mbti.equals("ENTP") || mbti.equals("ISTJ") || mbti.equals("ISFJ") || mbti.equals("ISTP")
							|| mbti.equals("ISFP")) {
						// 잠재적 관계
						score += 3;
					} else if (mbti.equals("ENTJ") || mbti.equals("ENFJ")) {
						// 끈끈한 관계
						score += 5;
					} else if (mbti.equals("INTJ") || mbti.equals("INFJ")) {
						// 이상적인관계
						score += 5;
					} else {
						score += 1;
					}
				} else if (my_mbti.equals("ISTP")) {
					if (mbti.equals("ENFP") || mbti.equals("INFP")) {
						// 맞지않는 유형
						score += 1;
					} else if (mbti.equals("ENTP") || mbti.equals("INTP") || mbti.equals("ISTJ") || mbti.equals("ISTP")
							|| mbti.equals("ISFP")) {
						// 갈등 관계
						score += 3;
					} else if (mbti.equals("ENTJ") || mbti.equals("INTJ") || mbti.equals("ENTP") || mbti.equals("ESTP")
							|| mbti.equals("ESFP")) {
						// 잠재적 관계
						score += 3;
					} else if (mbti.equals("ISFJ")) {
						// 끈끈한 관계
						score += 5;
					} else if (mbti.equals("ESFJ") || mbti.equals("ENFJ") || mbti.equals("INFJ")) {
						// 이상적인관계
						score += 5;
					} else {
						score += 1;
					}
				} else if (my_mbti.equals("ISFP")) {
					if (mbti.equals("ENTP") || mbti.equals("INTP") || mbti.equals("ISFJ")) {
						// 맞지않는 유형
						score += 1;
					} else if (mbti.equals("INFP") || mbti.equals("ISTP")) {
						// 갈등 관계
						score += 3;
					} else if (mbti.equals("ESFJ") || mbti.equals("ENFJ") || mbti.equals("ENFP") || mbti.equals("INFJ")
							|| mbti.equals("ESTP") || mbti.equals("ESFP") || mbti.equals("ISFP")) {
						// 잠재적 관계
						score += 3;
					} else if (mbti.equals("INTJ") || mbti.equals("ISTJ")) {
						// 끈끈한 관계
						score += 5;
					} else if (mbti.equals("ENTJ") || mbti.equals("ENTP")) {
						// 이상적인관계
						score += 5;
					} else {
						score += 1;
					}
				}
			} // 스터디그룹의 멤버 MBTI 확인끝
			System.out.println("score : " + score);
			mbti_avg = score / (mList.size());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return mbti_avg;
	}

}
