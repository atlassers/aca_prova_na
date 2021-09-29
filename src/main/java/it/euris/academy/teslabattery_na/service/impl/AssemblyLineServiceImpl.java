package it.euris.academy.teslabattery_na.service.impl;

import it.euris.academy.teslabattery_na.data.dto.AssemblyLineDto;
import it.euris.academy.teslabattery_na.data.model.AssemblyLine;
import it.euris.academy.teslabattery_na.exception.IdMustBeNullException;
import it.euris.academy.teslabattery_na.exception.IdMustNotBeNullException;
import it.euris.academy.teslabattery_na.repository.AssemblyLineRepository;
import it.euris.academy.teslabattery_na.service.AssemblyLineService;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssemblyLineServiceImpl implements AssemblyLineService {

  @Autowired
  private AssemblyLineRepository assemblyLineRepository;

  @Override
  public List<AssemblyLineDto> getAll() {
    return assemblyLineRepository.findAll()
        .stream().map(assemblyLine -> assemblyLine.toDto())
        .collect(Collectors.toList());
  }

  @Override
  public AssemblyLineDto get(Long id) {
    Optional<AssemblyLine> findById = assemblyLineRepository.findById(id);
    if(findById.isPresent()) {
      return findById.get().toDto();
    }
    return null;
  }

  @Override
  public AssemblyLineDto add(AssemblyLineDto assemblyLineDto) {
    if(assemblyLineDto.getAssemblyLineIdDto() != null) {
      throw new IdMustBeNullException();
    }
    return assemblyLineRepository.save(assemblyLineDto.toModel()).toDto();
  }

  @Override
  public AssemblyLineDto update(AssemblyLineDto assemblyLineDto) {
    if(assemblyLineDto.getAssemblyLineIdDto().isEmpty()) {
      throw new IdMustNotBeNullException();
    }
    return assemblyLineRepository.save(assemblyLineDto.toModel()).toDto();
  }

  @Override
  public Boolean delete(Long id) {
    assemblyLineRepository.deleteById(id);
    Optional<AssemblyLine> deletedAssemblyLine = assemblyLineRepository.findById(id);
    if(deletedAssemblyLine.isEmpty()) {
      return Boolean.TRUE;
    } else {
      return Boolean.FALSE;
    }
  }
}
