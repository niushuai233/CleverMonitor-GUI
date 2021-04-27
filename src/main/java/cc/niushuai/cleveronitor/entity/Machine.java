package cc.niushuai.cleveronitor.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author niushuai
 * @date 2021/4/27 17:53:51
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Machine {

    private Long id;
    private String machineNo;
    private String machineName;
    private Integer machineStationId;
}
