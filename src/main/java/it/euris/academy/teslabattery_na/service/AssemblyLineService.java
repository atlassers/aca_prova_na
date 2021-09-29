package it.euris.academy.teslabattery_na.service;

import it.euris.academy.teslabattery_na.data.dto.AssemblyLineDto;
import java.util.List;

public interface AssemblyLineService {

  List<AssemblyLineDto> getAll();

  AssemblyLineDto get(Long id);

  AssemblyLineDto add(AssemblyLineDto assemblyLineDto);

  AssemblyLineDto update(AssemblyLineDto assemblyLineDto);

  Boolean delete(Long id);
}
