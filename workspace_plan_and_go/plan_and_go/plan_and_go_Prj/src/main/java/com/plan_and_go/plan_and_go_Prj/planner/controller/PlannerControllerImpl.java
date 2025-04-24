package com.plan_and_go.plan_and_go_Prj.planner.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.plan_and_go.plan_and_go_Prj.place.service.PlaceService;
import com.plan_and_go.plan_and_go_Prj.place.vo.PlaceVO;
import com.plan_and_go.plan_and_go_Prj.planner.service.PlannerService;
import com.plan_and_go.plan_and_go_Prj.planner.vo.ActivityVO;
import com.plan_and_go.plan_and_go_Prj.planner.vo.ScheduleVO;

@Controller("plannerController")
@SessionAttributes({"region", "start_date", "end_date", "group_id", "schedule_id"})
@RequestMapping("/planner")
public class PlannerControllerImpl implements PlannerController {
	@Autowired
	private PlaceService placeService;

	@Autowired
	private PlannerService plannerService;

	@Override
	@RequestMapping(value = "/planForm.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String planForm(@RequestParam("region") String region, @RequestParam("group_id") String group_id,
			HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
		// viewName을 요청 속성에서 가져옴
		System.out.println("planForm.do");
		System.out.println("group_id :::: " + group_id);
//		List<RegionVO> region = placeService.getRegion();
		model.addAttribute("region", region);
		model.addAttribute("group_id", group_id);

		return "/planner/planForm"; // planForm.jsp로 이동
	}

	@RequestMapping(value = "/planForm2.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String planForm2(@RequestParam("region") String region, 
	                        @RequestParam("start_date") String start_date,
	                        @RequestParam("end_date") String end_date, 
	                        @RequestParam("group_id") String group_id, 
	                        @RequestParam("schedule_id") String schedule_id, 
	                        Model model) {
	    System.out.println("planForm2.do, region : " + region);
	    System.out.println("planForm2.do, schedule_id : " + schedule_id);
	    

	    // 장소 목록 가져오기
	    List<PlaceVO> place = placeService.getPlaces(region);
	    List<ActivityVO> activityList = plannerService.getActivity(Integer.parseInt(schedule_id));

	    List<String> dateList = new ArrayList<String>();
	    System.out.println("planform2.do start_date : " + start_date);
	    LocalDate start = LocalDate.parse(start_date);
	    System.out.println("planform2 start : " + start);
	    LocalDate end = LocalDate.parse(end_date);
	    while (!start.isAfter(end)) {
	        dateList.add(start.toString());
	        start = start.plusDays(1);
	    }
	    System.out.println("planform2 start : " + start);
	    System.out.println("end : " + end);

	    // 모델에 추가
	    model.addAttribute("region", region);
	    model.addAttribute("place", place);
	    model.addAttribute("activityList", activityList);
	    model.addAttribute("schedule_id", schedule_id);
	    model.addAttribute("dateList", dateList);
	    model.addAttribute("group_id", group_id);
	    model.addAttribute("start_date", start_date);
	    model.addAttribute("end_date", end_date);

	    return "/planner/planForm2"; // View 반환
	}

	@RequestMapping(value = "/saveSchedule.do", method = RequestMethod.POST)
    public String insertSchedule(@RequestParam("region") String region,
                                 @RequestParam("start_date") String start_date,
                                 @RequestParam("end_date") String end_date,
                                 @RequestParam("group_id") String group_id,
                                 @RequestParam("schedule_name") String schedule_name,
                                 Model model) throws Exception {

        // 일정 추가 로직
        ScheduleVO schedule = new ScheduleVO();
        schedule.setGroup_id(Integer.parseInt(group_id));
        schedule.setRegion_name(region);
        schedule.setSchedule_name(schedule_name);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        schedule.setStart_date(sdf.parse(start_date));
        schedule.setEnd_date(sdf.parse(end_date));

        int schedule_id = plannerService.addSchedule(schedule);
        
        System.out.println("saveSchedule.do startdate : " + start_date);

        // 세션에 데이터 저장
        model.addAttribute("schedule_id", schedule_id);
        model.addAttribute("region", region);
        model.addAttribute("start_date", start_date);
        model.addAttribute("end_date", end_date);
        model.addAttribute("group_id", group_id);

        return "redirect:/planner/planForm2.do";
    }

	@RequestMapping(value = "/saveActivity.do", method = RequestMethod.POST)
	public String insertActivity(
	        @RequestParam("ACTIVITY_NAME") String ACTIVITY_NAME,
	        @RequestParam("ACTIVITY_TIME") String ACTIVITY_TIME, 
	        @RequestParam("EXPECTED_COST") String EXPECTED_COST,
	        @RequestParam("ACTIVITY_DATE") String ACTIVITY_DATE, 
	        @RequestParam("SCHEDULE_ID") String SCHEDULE_ID,
	        @RequestParam("PLACE_NAME") String PLACE_NAME, 
	        @RequestParam("ACTUAL_COST") String ACTUAL_COST,
	        @RequestParam("region") String region, 
	        @RequestParam("start_date") String start_date,
	        @RequestParam("end_date") String end_date, 
	        @RequestParam("group_id") String group_id,
	        @RequestParam("COMMENT") String COMMENT,
	        Model model) throws Exception {
	    
	    System.out.println("ACTIVITY_NAME : " + ACTIVITY_NAME);
	    System.out.println("ACTIVITY_TIME : " + ACTIVITY_TIME);
	    System.out.println("EXPECTED_COST : " + EXPECTED_COST);
	    System.out.println("ACTIVITY_DATE : " + ACTIVITY_DATE);
	    System.out.println("schedule_id : " + SCHEDULE_ID);
	    System.out.println("PLACE_NAME : " + PLACE_NAME);
	    System.out.println("ACTUAL_COST : " + ACTUAL_COST);
	    System.out.println("COMMENT : " + COMMENT);
	    System.out.println("activity startDate : " + start_date);

	    // 날짜 변환
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    Date activityDate = sdf.parse(ACTIVITY_DATE);
	    
	    // Activity 객체 생성 및 데이터 설정
	    ActivityVO activity = new ActivityVO();
	    activity.setACTIVITY_NAME(ACTIVITY_NAME);
	    activity.setACTIVITY_TIME(ACTIVITY_TIME);
	    activity.setEXPECTED_COST(EXPECTED_COST);
	    activity.setACTIVITY_DATE(activityDate);
	    activity.setSCHEDULE_ID(Integer.parseInt(SCHEDULE_ID));
	    activity.setPLACE_NAME(PLACE_NAME);
	    activity.setACTUAL_COST(ACTUAL_COST);
	    activity.setCOMMENT(COMMENT);

	    // DB에 추가
	    plannerService.addActivity(activity); 
	    System.out.println("saveActivity.do startdate : " + start_date);

	    model.addAttribute("schedule_id", SCHEDULE_ID);
	    model.addAttribute("region", region);
	    model.addAttribute("start_date", start_date);
	    model.addAttribute("end_date", end_date);
	    model.addAttribute("group_id", group_id);
	    model.addAttribute("activity", activity);

	    return "redirect:/planner/planForm2.do";
	}

	@RequestMapping(value = "/removeActivity.do", method = RequestMethod.POST)
	public String getActivitys(
			@RequestParam("ACTIVITY_ID") String ACTIVITY_ID, 
			@RequestParam("region") String region, 
            @RequestParam("start_date") String start_date,
            @RequestParam("end_date") String end_date, 
            @RequestParam("group_id") String group_id, 
            @RequestParam("schedule_id") String schedule_id,
            HttpServletRequest request,
			HttpServletResponse response,
			Model model) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("html/text;charset=utf-8");
		
		plannerService.removeActivity(Integer.parseInt(ACTIVITY_ID));
		
		System.out.println("removeActivity.do startdate : " + start_date);
		
		model.addAttribute("schedule_id", schedule_id);
	    model.addAttribute("region", region);
	    model.addAttribute("start_date", start_date);
	    model.addAttribute("end_date", end_date);
	    model.addAttribute("group_id", group_id);
		
		return "redirect:/planner/planForm2.do"; 
	}
	
	@RequestMapping(value = "/updateSchedule.do", method = RequestMethod.POST)
	public String updateSchedule(
			@RequestParam("scheduleId") String schedule_id, 
            HttpServletRequest request,
			HttpServletResponse response,
			Model model) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("html/text;charset=utf-8");
		
		List<ScheduleVO> activityList = plannerService.getActivityUpdate(Integer.parseInt(schedule_id));
		
		if (!activityList.isEmpty()) {
			ScheduleVO scheduleVO = activityList.get(0);
		    System.out.println("activityList.get(0) = " + activityList.get(0));
		    String region = scheduleVO.getRegion_name();
			Date startDate = scheduleVO.getStart_date();
			Date endDate = scheduleVO.getEnd_date();
			int group_id = scheduleVO.getGroup_id();
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String start_date = sdf.format(startDate);
			String end_date = sdf.format(endDate);
			
			System.out.println("updateSchedule.do start_date : " + start_date);
			System.out.println("String end_date : " + end_date);
			
			model.addAttribute("schedule_id", schedule_id);
		    model.addAttribute("region", region);
		    model.addAttribute("start_date", start_date);
		    model.addAttribute("end_date", end_date);
		    model.addAttribute("group_id", group_id);
			
			return "redirect:/planner/planForm2.do"; 
		} else {
		    System.out.println("activityList가 비어 있습니다.");
		}
		
		return "redirect:/planner/planForm2.do"; 
	}
	
	@RequestMapping(value = "/updateActivity.do", method = RequestMethod.POST)
	public String updateActivity(
			@RequestParam("UPDATE_ACTIVITY_NAME") String ACTIVITY_NAME,
	        @RequestParam("UPDATE_ACTIVITY_TIME") String ACTIVITY_TIME, 
	        @RequestParam("UPDATE_EXPECTED_COST") String EXPECTED_COST,
	        @RequestParam("UPDATE_ACTIVITY_DATE") String ACTIVITY_DATE, 
	        @RequestParam("SCHEDULE_ID") String SCHEDULE_ID,
	        @RequestParam("ACTIVITY_ID") String ACTIVITY_ID,
	        @RequestParam("UPDATE_PLACE_NAME") String PLACE_NAME, 
	        @RequestParam("UPDATE_ACTUAL_COST") String ACTUAL_COST,
	        @RequestParam("region") String region, 
	        @RequestParam("start_date") String start_date,
	        @RequestParam("end_date") String end_date, 
	        @RequestParam("group_id") String group_id,
	        @RequestParam("UPDATE_COMMENT") String UPDATE_COMMENT,
	        Model model) throws Exception {
		
		System.out.println("ACTIVITY_ID : " + ACTIVITY_ID);
		System.out.println("ACTIVITY_NAME : " + ACTIVITY_NAME);
	    System.out.println("ACTIVITY_TIME : " + ACTIVITY_TIME);
	    System.out.println("EXPECTED_COST : " + EXPECTED_COST);
	    System.out.println("ACTIVITY_DATE : " + ACTIVITY_DATE);
	    System.out.println("schedule_id : " + SCHEDULE_ID);
	    System.out.println("PLACE_NAME : " + PLACE_NAME);
	    System.out.println("ACTUAL_COST : " + ACTUAL_COST);
	    System.out.println("UPDATE_COMMENT : " + UPDATE_COMMENT);
	    System.out.println("updateActivity.do startdate : " + start_date);
	    
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    Date activityDate = sdf.parse(ACTIVITY_DATE);
	    
	 // Activity 객체 생성 및 데이터 설정
	    ActivityVO activity = new ActivityVO();
	    activity.setACTIVITY_ID(Integer.parseInt(ACTIVITY_ID));
	    activity.setACTIVITY_NAME(ACTIVITY_NAME);
	    activity.setACTIVITY_TIME(ACTIVITY_TIME);
	    activity.setEXPECTED_COST(EXPECTED_COST);
	    activity.setACTIVITY_DATE(activityDate);
	    activity.setPLACE_NAME(PLACE_NAME);
	    activity.setACTUAL_COST(ACTUAL_COST);
	    activity.setCOMMENT(UPDATE_COMMENT);
		
		plannerService.updateActivity(activity);
		
		model.addAttribute("schedule_id", SCHEDULE_ID);
		model.addAttribute("region", region);
	    model.addAttribute("start_date", start_date);
	    model.addAttribute("end_date", end_date);
	    model.addAttribute("group_id", group_id);
		
		return "redirect:/planner/planForm2.do";
	}
	
	@RequestMapping(value = "/clearSession.do", method = RequestMethod.POST)
    public String clearSession(SessionStatus sessionStatus,
    		@RequestParam("MEMBER_ID") String MEMBER_ID) {
        sessionStatus.setComplete(); // 세션에서 제거
        return "redirect:/board/myPage.do?MEMBER_ID=" + MEMBER_ID;
    }
}
