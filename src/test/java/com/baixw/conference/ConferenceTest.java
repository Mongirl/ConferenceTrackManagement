package com.baixw.conference;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

public class ConferenceTest extends TestCase{
	
	public void testApp()
    {
		List<String> conferenceNameList = new ArrayList<String>();
		conferenceNameList.add("Overdoing it in Python 45min");
		conferenceNameList.add("Lua for the Masses 30min");
		conferenceNameList.add("Ruby Errors from Mismatched Gem Versions 45min");
		conferenceNameList.add("Common Ruby Errors 45min");
		conferenceNameList.add("Rails for Python Developers lightning");
		conferenceNameList.add("Communicating Over Distance 60min");
		conferenceNameList.add("Accounting-Driven Development 45min");
		conferenceNameList.add("Woah 30min");
		conferenceNameList.add("Sit Down and Write 30min");
		conferenceNameList.add("Pair Programming vs Noise 45min");
		conferenceNameList.add("Rails Magic 60min");
		conferenceNameList.add("Ruby on Rails: Why We Should Move On 60min");
		conferenceNameList.add("Clojure Ate Scala (on my project) 45min");
		conferenceNameList.add("Programming in the Boondocks of Seattle 30min");
		conferenceNameList.add("Ruby vs. Clojure for Back-End Development 30min");
		conferenceNameList.add("Ruby on Rails Legacy App Maintenance 60min");
		conferenceNameList.add("A World Without HackerNews 30min");
		conferenceNameList.add("User Interface CSS in Rails Apps 30min");
		
		ConferenceTrackManagement c = new ConferenceTrackManagement();
		c.conferenceTrackManagement(conferenceNameList);
       
    }

}
