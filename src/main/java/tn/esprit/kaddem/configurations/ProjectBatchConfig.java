//package tn.esprit.kaddem.configurations;
//
//import lombok.AllArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
//import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.batch.item.ItemProcessor;
//import org.springframework.batch.item.ItemWriter;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import tn.esprit.kaddem.batch.ProjectProcessor;
//import tn.esprit.kaddem.batch.ProjectReader;
//import tn.esprit.kaddem.batch.ProjectWriter;
//import tn.esprit.kaddem.entities.Equipe;
//
//@Configuration
///*3. Activer le traitement par lot */
//@EnableBatchProcessing
//@Slf4j
//@AllArgsConstructor
//public class ProjectBatchConfig {
//
//    private static final String JOB_NAME = "listProjectJob";
//    private static final String STEP_NAME = "processingStep";
//
//    private JobBuilderFactory jobBuilderFactory;
//
//    private StepBuilderFactory stepBuilderFactory;
//
//
//    @Bean
//    public Job listProjectsJob(Step step1) {
//
//        return jobBuilderFactory.get(JOB_NAME).start(step1).build();
//    }
//
//    @Bean
//    public Step projectStep() {
//
//        try {
//            return stepBuilderFactory.get(STEP_NAME)
//                    .<Equipe, Equipe>chunk(2).reader(projectItemReader().read())
//                    .processor(projectItemProcessor()).writer(projectItemWriter())
//                    .exceptionHandler((context, throwable) -> log.error("Skipping record on file. cause="+ throwable.getCause()))
//                    .build();
//        } catch (Exception e) {
//            log.error("End Batch Step");
//            return stepBuilderFactory.get(STEP_NAME).chunk(2).build();
//        }
//
//    }
//
//
//    @Bean
//    public ProjectReader projectItemReader() {
//        return new ProjectReader();
//    }
//
//    @Bean
//    public ItemProcessor<Equipe, Equipe> projectItemProcessor() {
//        return new ProjectProcessor();
//    }
//
//
//
//    @Bean
//    public ItemWriter<Equipe> projectItemWriter() {
//        return new ProjectWriter();
//    }
//}
