package com.baixw.conference;

import java.util.ArrayList;
import java.util.List;
/**
 * 会议轨道安排
 * @author baixw
 *
 */
public class ConferenceTrackManagement {
	
	/**
	 * 根据输入的会议组合输出轨道
	 * @param conferenceNameList 需要安排的会议名称集合
	 */
	public  void conferenceTrackManagement(List<String> conferenceNameList) {
		List<Conference> conferenceList = new ArrayList<Conference>();
		List<Conference> morningList = new ArrayList<Conference>();
		List<Conference> aftrtnoonList = new ArrayList<Conference>();
		int timeMorning = 0;
		int timeAftrtnoon = 0;
		if(conferenceNameList != null && conferenceNameList.size() > 0) {
			for (String conferenceName : conferenceNameList) {
				//获取每个会议的时长
				Conference conference = this.getNameAndMin(conferenceName);
				conferenceList.add(conference);
			}
			if(conferenceList.size() > 0) {
				for (Conference conference : conferenceList) {
					//上午时间安排在12点之前，共180分钟，超出的安排在下午
					if(timeMorning + conference.getMin() <= 180) {
						//第一个安排在九点
						if(timeMorning == 0) {
							conference.setTime("9:00AM");
						}else {
							//后面的按会议时长依次排
							if(timeMorning/60 > 0) {
								conference.setTime(9 + timeMorning/60 + ":" + (timeMorning%60 == 0?"00AM":timeMorning%60+"AM"));
							}else {
								conference.setTime("9:" + timeMorning +"AM");
							}
							
						}
						timeMorning += conference.getMin();
						morningList.add(conference);
						//下午会议安排在1点之后五点之前，共240分。
					}else if(timeAftrtnoon + conference.getMin() <= 240){
						//下午第一个在1点
						if(timeAftrtnoon == 0) {
							conference.setTime("1:00PM");
						}else {
							//后面的按时长依次排
							if(timeAftrtnoon/60 > 0) {
								conference.setTime(1 + timeAftrtnoon/60 + ":" + (timeAftrtnoon%60 == 0?"00PM":timeAftrtnoon%60+"PM"));
							}else {
								conference.setTime("1:" + timeAftrtnoon+"PM");
							}
						}
						timeAftrtnoon += conference.getMin();
						aftrtnoonList.add(conference);
					}
				}
				//按时间顺序依次输出
				if(morningList.size() > 0) {
					for(int i = 0;i<morningList.size();i++) {
						System.out.println(morningList.get(i).getTime() + "  " + morningList.get(i).getName());
					}
				}
				//12点午餐
				System.out.println("12:00PM Lunch");
				if(aftrtnoonList.size() > 0) {
					for(int i = 0;i<aftrtnoonList.size();i++) {
						System.out.println(aftrtnoonList.get(i).getTime() + "  " + aftrtnoonList.get(i).getName());
					}
				}
				System.out.println("05:00PM Networking Event");
				
				
			}
		}
		
		
		
	}
	
	/**
	 * 根据会议名称获取会议时长
	 * @param conferenceName 会议名称
	 * @return
	 */
	public Conference getNameAndMin(String conferenceName) {
		Conference conference = null;
		try {
			conference = new Conference();
			conference.setName(conferenceName);
			if(conferenceName.contains("lightning")) {
				conference.setMin(5);
			}else if(conferenceName.contains("min")) {
				String min = conferenceName.substring(conferenceName.lastIndexOf(" ")+1, conferenceName.lastIndexOf("min"));
				conference.setMin(Integer.parseInt(min));
			}
			
		} catch (Exception e) {
			
		}
		
		return conference;
	}
	

}
