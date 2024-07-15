package vn.ths.BTCuoiKhoa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.ths.BTCuoiKhoa.dao.TranscriptRepository;
import vn.ths.BTCuoiKhoa.entity.Transcript;

import java.util.List;
import java.util.Optional;

@Service
public class TranscriptService implements MyService<Transcript> {
    private TranscriptRepository transcriptRepository;

    @Autowired
    public TranscriptService(TranscriptRepository transcriptRepository) {
        this.transcriptRepository = transcriptRepository;
    }

    @Override
    public List<Transcript> getAll() {
        return transcriptRepository.findAll();
    }

    @Override
    public Transcript getById(int id) {
        Optional<Transcript> optionalTranscript = transcriptRepository.findById(id);
        return optionalTranscript.orElse(null);
    }

    @Override
    @Transactional
    public Transcript add(Transcript transcript) {
        return transcriptRepository.saveAndFlush(transcript);
    }

    @Override
    @Transactional
    public Transcript update(Transcript transcript) {
        Optional<Transcript> optionalTranscript = transcriptRepository.findById(transcript.getId());
        if(optionalTranscript.isPresent()){
            return transcriptRepository.saveAndFlush(transcript);
        }else
            return null;
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        transcriptRepository.deleteById(id);
    }

    @Override
    public Transcript findByName(String name) {
        return null;
    }
}
