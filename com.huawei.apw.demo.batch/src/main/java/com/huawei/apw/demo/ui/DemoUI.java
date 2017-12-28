package com.huawei.apw.demo.ui;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.huawei.apw.demo.batch.DemoBatchConfiguration;
import com.huawei.apw.demo.batch.beans.Person;
import com.huawei.apw.demo.batch.listener.DemoJobCompletionNotificationListener;
import com.huawei.apw.demo.batch.orm.PersonMapper;

@RestController
@RequestMapping("/demo")
public class DemoUI {
	
	@Autowired
	private PersonMapper mapper;
	
	@RequestMapping("/liquid")
	public Map<String, Person> liquid(int length){
		Map<String, Person> resp = new HashMap<>(length);
		List<Person> list = mapper.findAll();
		int index = length > list.size()?list.size():length;
		while(!(--index < 0)){
			Person person = list.get(index);
			resp.put(person.getFirstName(), person);
		}
		return resp;
	}
	
	@PostMapping("/liquid")
	public String liquidPost(@RequestBody Person person){
		int exitCode = mapper.addPersonItem(person);
		return String.valueOf(exitCode);
	}
	
//	@Autowired
//	private JobLauncher jobLauncher;
//	
//	@Autowired
//	private DemoBatchConfiguration demoConfig;
//	
//	
//	@RequestMapping("/suffixUserJob")
//	public String suffixUserJob() throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException{
//		DemoJobCompletionNotificationListener listener = new DemoJobCompletionNotificationListener();
//		JobExecution jobExcution = jobLauncher.run(demoConfig.suffixUserJob(listener), new JobParameters());
//		return jobExcution.getJobConfigurationName() + " : " + jobExcution.getExitStatus();
//	}

}
