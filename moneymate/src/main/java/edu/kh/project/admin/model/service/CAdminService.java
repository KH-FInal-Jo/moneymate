package edu.kh.project.admin.model.service;

import java.util.Map;

public interface CAdminService {

	Map<String, Object> selectReportList(int cp);

	int reportConfirm(Map<String, Object> paramMap);

	int reportDupCheck(Map<String, Object> paramMap);

	Map<String, Object> selectPayList(int cp);

	Map<String, Object> selectPayList(Map<String, Object> paramMap, int cp);

}
