package it.euris.academy.teslabattery_na.service.impl;

import it.euris.academy.teslabattery_na.data.dto.FormulaDto;
import it.euris.academy.teslabattery_na.data.model.Formula;
import it.euris.academy.teslabattery_na.exception.IdMustBeNullException;
import it.euris.academy.teslabattery_na.exception.IdMustNotBeNullException;
import it.euris.academy.teslabattery_na.repository.FormulaRepository;
import it.euris.academy.teslabattery_na.service.FormulaService;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FormulaServiceImpl implements FormulaService {

  @Autowired
  private FormulaRepository formulaRepository;

  @Override
  public List<FormulaDto> getAll() {
    return formulaRepository.findAll()
        .stream().map(formula -> formula.toDto())
        .collect(Collectors.toList());
  }

  @Override
  public FormulaDto get(Long id) {
    Optional<Formula> findById = formulaRepository.findById(id);
    if(findById.isPresent()) {
      return findById.get().toDto();
    }
    return null;
  }

  @Override
  public FormulaDto add(FormulaDto formulaDto) {
    if(formulaDto.getFormulaIdDto() != null) {
      throw new IdMustBeNullException();
    }
    return formulaRepository.save(formulaDto.toModel()).toDto();
  }

  @Override
  public FormulaDto update(FormulaDto formulaDto) {
    if(formulaDto.getFormulaIdDto().isEmpty()) {
      throw new IdMustNotBeNullException();
    }
    return formulaRepository.save(formulaDto.toModel()).toDto();
  }

  @Override
  public Boolean delete(Long id) {
    formulaRepository.deleteById(id);
    Optional<Formula> deletedFormula = formulaRepository.findById(id);
    if(deletedFormula.isEmpty()) {
      return Boolean.TRUE;
    } else {
      return Boolean.FALSE;
    }
  }
}
