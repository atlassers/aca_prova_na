package it.euris.academy.teslabattery_na.service.impl;

import it.euris.academy.teslabattery_na.data.dto.FormulaComponentDto;
import it.euris.academy.teslabattery_na.data.model.FormulaComponent;
import it.euris.academy.teslabattery_na.data.model.key.FormulaComponentKey;
import it.euris.academy.teslabattery_na.exception.IdMustBeNullException;
import it.euris.academy.teslabattery_na.exception.IdMustNotBeNullException;
import it.euris.academy.teslabattery_na.repository.FormulaComponentRepository;
import it.euris.academy.teslabattery_na.service.FormulaComponentService;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FormulaComponentServiceImpl implements FormulaComponentService {

  @Autowired
  private FormulaComponentRepository formulaComponentRepository;

  @Override
  public List<FormulaComponentDto> getAll() {
    return formulaComponentRepository.findAll()
        .stream().map(formulaComponent -> formulaComponent.toDto())
        .collect(Collectors.toList());
  }

  @Override
  public FormulaComponentDto get(FormulaComponentKey id) {
    Optional<FormulaComponent> findById = formulaComponentRepository.findById(id);
    if(findById.isPresent()) {
      return findById.get().toDto();
    }
    return null;
  }

  @Override
  public FormulaComponentDto add(FormulaComponentDto formulaDto) {
    if(formulaDto.getFormulaIdDto() != null) {
      throw new IdMustBeNullException();
    }
    return formulaComponentRepository.save(formulaDto.toModel()).toDto();
  }

  @Override
  public FormulaComponentDto update(FormulaComponentDto formulaDto) {
    if(formulaDto.getFormulaIdDto().isEmpty()) {
      throw new IdMustNotBeNullException();
    }
    return formulaComponentRepository.save(formulaDto.toModel()).toDto();
  }

  @Override
  public Boolean delete(FormulaComponentKey id) {
    formulaComponentRepository.deleteById(id);
    Optional<FormulaComponent> deletedFormula = formulaComponentRepository.findById(id);
    if(deletedFormula.isEmpty()) {
      return Boolean.TRUE;
    } else {
      return Boolean.FALSE;
    }
  }
}
