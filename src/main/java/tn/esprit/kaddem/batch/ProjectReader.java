//package tn.esprit.kaddem.batch;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.batch.item.ItemReader;
//import org.springframework.batch.item.NonTransientResourceException;
//import org.springframework.batch.item.ParseException;
//import org.springframework.batch.item.UnexpectedInputException;
//import org.springframework.batch.item.file.FlatFileItemReader;
//import org.springframework.batch.item.file.LineMapper;
//import org.springframework.batch.item.file.mapping.DefaultLineMapper;
//import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.io.ClassPathResource;
//import tn.esprit.kaddem.entities.Equipe;
//import tn.esprit.kaddem.services.IEquipeService;
//
//@Slf4j
//public class ProjectReader implements ItemReader<ItemReader<Equipe>> {
//    @Autowired
//    private IEquipeService equipeService;
//
//
//    private static final String FILE_NAME = "project.csv";
//    private static final String READER_NAME = "projectItemReader";
//
//    private String names = "name" ;
//
//
//    private String delimiter = ",";
//
//
//    @Override
//    public ItemReader<Equipe> read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
//        log.error("Start Batch Item Reader");
//        FlatFileItemReader<Equipe> reader = new FlatFileItemReader<>();
//        reader.setResource(new ClassPathResource(FILE_NAME));
//        reader.setName(READER_NAME);
//        reader.setLinesToSkip(1);
//        reader.setLineMapper(projectLineMapper());
//
//        return reader;
//    }
//
//    public LineMapper<Equipe> projectLineMapper() {
//
//        log.info("Start Batch Line Mapper");
//
//        final DefaultLineMapper<Equipe> defaultLineMapper = new DefaultLineMapper<>();
//        final DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
//        lineTokenizer.setDelimiter(delimiter);
//        lineTokenizer.setStrict(false);
//        lineTokenizer.setNames(names.split(delimiter));
//        defaultLineMapper.setLineTokenizer(lineTokenizer);
//        defaultLineMapper.setFieldSetMapper(fieldSet -> {
//            if (fieldSet.readBoolean(2)) { // on a récupérer le parametre terminated du fichier projet.csv et verifier que sa valeur est true
//                return equipeService.retrieveEquipe(fieldSet.readInt(1));
//
//            }
//            else {
//                return null;
//            }
//
//        });
//        return defaultLineMapper;
//    }
//}
