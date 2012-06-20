/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.spec;

import business.BusinessException;
import java.util.List;
import vo.NumberCalledVO;

/**
 *
 * @author luciano
 */
public interface IFatura {
        
        List<NumberCalledVO> importFat(String address, int header_discard) throws BusinessException;
        boolean calculate(List<NumberCalledVO> listCalled, String address) throws BusinessException;
        void generateGenericFiles(String address) throws BusinessException;
    
}
