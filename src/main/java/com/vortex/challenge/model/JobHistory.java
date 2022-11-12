package com.vortex.challenge.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@Table(name = "JOB_HISTORY")
public class JobHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "JOB_HISTORY_ID")
    private int jobHistoryId;

    @ManyToOne
    @JoinColumn(name = "EMPLOYEE_ID")
    private Employee employeeId;
    @Column(name = "START_DATE")
    private Date startDate;
    @Column(name = "END_DATE")
    private Date endDate;
    @ManyToOne
    @JoinColumn(name = "JOB_ID")
    private Job jobId;
    @ManyToOne
    @JoinColumn(name = "DEPARTMENT_ID")
    private Department departmentId;

    public JobHistory(Employee employeeId, Date startDate, Date endDate, Job jobId, Department department){
        this.employeeId = employeeId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.jobId = jobId;
        this.departmentId = department;
    }


}
