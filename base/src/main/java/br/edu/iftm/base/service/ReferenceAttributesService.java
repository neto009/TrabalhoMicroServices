package br.edu.iftm.base.service;

import br.edu.iftm.base.entity.ReferenceAttributes;
import br.edu.iftm.base.entity.attributes.DateDocument;
import br.edu.iftm.base.entity.attributes.NumberDocument;
import br.edu.iftm.base.entity.attributes.StringDocument;
import br.edu.iftm.base.repository.DateDocumentRepository;
import br.edu.iftm.base.repository.NumberDocumentRepository;
import br.edu.iftm.base.repository.ReferenceAttributesRepository;
import br.edu.iftm.base.repository.StringDocumentRepository;
import br.edu.iftm.base.repository.impl.ReferenceAttibutesImplements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ReferenceAttributesService {

    @Autowired
    private ReferenceAttributesRepository referenceAttributesRepository;

    @Autowired
    private NumberDocumentRepository numberDocumentRepository;

    @Autowired
    private DateDocumentRepository dateDocumentRepository;

    @Autowired
    private StringDocumentRepository stringDocumentRepository;

    @Autowired
    private ReferenceAttibutesImplements referenceAttibutesImplements;

    public ReferenceAttributes save() {
        return referenceAttributesRepository.save(ReferenceAttributes
                .builder()
                .numberDocument(Arrays.asList(numberDocumentRepository.save(new NumberDocument(null))))
                .stringDocument(Arrays.asList(stringDocumentRepository.save(new StringDocument(null))))
                .dateDocument(Arrays.asList(dateDocumentRepository.save(new DateDocument(null))))
                .build());
    }

    public ReferenceAttributes insertLine(String attributesId) {
        NumberDocument numberDocument = numberDocumentRepository.save(new NumberDocument(null));
        DateDocument dateDocument = dateDocumentRepository.save(new DateDocument(null));
        StringDocument stringDocuments = stringDocumentRepository.save(new StringDocument(null));

        referenceAttibutesImplements.saveNumberDocument(attributesId, numberDocument.getId());
        referenceAttibutesImplements.saveDateDocument(attributesId, dateDocument.getId());
        referenceAttibutesImplements.saveStringDocument(attributesId, stringDocuments.getId());

        return ReferenceAttributes.builder()
                .id(attributesId)
                .dateDocument(Arrays.asList(dateDocument))
                .numberDocument(Arrays.asList(numberDocument))
                .stringDocument(Arrays.asList(stringDocuments))
                .build();
    }

    public NumberDocument insertNumberValue(String id, Long value) {
        return numberDocumentRepository.save(new NumberDocument(id, value));
    }

    public DateDocument insertDateValue(String id, String value) {
        return dateDocumentRepository.save(new DateDocument(id, value));
    }

    public StringDocument insertStringValue(String id, String value) {
        return stringDocumentRepository.save(new StringDocument(id, value));
    }
}
