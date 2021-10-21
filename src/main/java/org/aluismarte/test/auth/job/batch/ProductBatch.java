package org.aluismarte.test.auth.job.batch;

import org.aluismarte.test.auth.domain.Product;
import org.aluismarte.test.auth.job.batch.listener.JobListener;
import org.aluismarte.test.auth.job.batch.processor.ProductsProcessor;
import org.aluismarte.test.auth.job.batch.reader.ProductsReader;
import org.aluismarte.test.auth.job.batch.writer.ProductWriter;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by aluis on 10/21/2021.
 */
@Configuration
public class ProductBatch {

    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;

    private final ProductsProcessor productsProcessor;
    private final ProductsReader productsReader;
    private final ProductWriter productWriter;

    public ProductBatch(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory, ProductsProcessor productsProcessor, ProductsReader productsReader, ProductWriter productWriter) {
        this.jobBuilderFactory = jobBuilderFactory;
        this.stepBuilderFactory = stepBuilderFactory;
        this.productsProcessor = productsProcessor;
        this.productsReader = productsReader;
        this.productWriter = productWriter;
    }

    @Bean
    public Step productStep1() {
        return stepBuilderFactory.get("step1").<Product, Product>chunk(1)
                .reader(productsReader)
                .processor(productsProcessor)
                .writer(productWriter)
                .allowStartIfComplete(true)
                .build();
    }

    @Bean
    public Job forgotPasswordJob(JobListener jobListener) {
        return jobBuilderFactory.get("productJob")
                .listener(jobListener)
                .flow(productStep1())
                .end()
                .build();
    }
}
