
import org.junit.Test
import org.junit.Assert.*

class MainKtTest {
    @Test
    fun countCommission() {
        // default arrange
        //act
        val result = Main.countCommission(
            nowPay = 10000
        )
        //assert
        assertEquals(1, result) // Кладем сборку на гитхабе нужное значение 0
    }

    @Test
    fun countCommissionVK() {
        //arrange
        val account = "VK pay"
        val beforePay = 0
        val nowPay = 10000
        //act
        val result = Main.countCommission(
            account = account,
            beforePay = beforePay,
            nowPay = nowPay
        )
        //assert
        assertEquals(0, result)
    }

    @Test
    fun countCommissionMasetrcardWithCommission() {
        //arrange
        val account  = "Masetrcard"
        val beforePay  = 100000
        val nowPay = 10000
        //act
        val result = Main.countCommission(
            account = account,
            beforePay = beforePay,
            nowPay = nowPay
        )
        //assert
        assertEquals(80, result)
    }

    @Test
    fun countCommissionMasetrcardWithoutCommission() {
        //arrange
        val account = "Masetrcard"
        val beforePay = 70000
        val nowPay = 10000
        //act
        val result = Main.countCommission(
            account = account,
            beforePay = beforePay,
            nowPay = nowPay
        )
        //assert
        assertEquals(0, result)
    }

    @Test
    fun countCommissionMaestroWithCommission() {
        //arrange
        val account = "Maestro"
        val beforePay = 100000
        val nowPay = 10000
        //act
        val result = Main.countCommission(
            account = account,
            beforePay = beforePay,
            nowPay = nowPay
        )
        //assert
        assertEquals(80, result)
    }

    @Test
    fun countCommissionMaestroWithoutCommission() {
        //arrange
        val account = "Maestro"
        val beforePay = 70000
        val nowPay = 10000
        //act
        val result = Main.countCommission(
            account = account,
            beforePay = beforePay,
            nowPay = nowPay
        )
        //assert
        assertEquals(0, result)
    }

    @Test
    fun countCommissionVisaWithCommission() {
        //arrange
        val account = "Visa"
        val beforePay = 0
        val nowPay = 1000
        //act
        val result = Main.countCommission(
            account = account,
            beforePay = beforePay,
            nowPay = nowPay
        )
        //assert
        assertEquals(35, result)
    }

    @Test
    fun countCommissionVisaWithoutCommission() {
        //arrange
        val account = "Visa"
        val beforePay = 0
        val nowPay = 10000
        //act
        val result = Main.countCommission(
            account = account,
            beforePay = beforePay,
            nowPay = nowPay
        )
        //assert
        assertEquals(75, result)
    }

    @Test
    fun countCommissionMirWithCommission() {
        //arrange
        val account = "Мир"
        val beforePay = 0
        val nowPay = 1000
        //act
        val result = Main.countCommission(
            account = account,
            beforePay = beforePay,
            nowPay = nowPay
        )
        //assert
        assertEquals(35, result)
    }

    @Test
    fun countCommissionMirWithoutCommission() {
        //arrange
        val account = "Мир"
        val beforePay = 0
        val nowPay = 10000
        //act
        val result = Main.countCommission(
            account = account,
            beforePay = beforePay,
            nowPay = nowPay
        )
        //assert
        assertEquals(75, result)
    }

    @Test
    fun isLimitForCardExceptVKPayTrueBeforePay() {
        //arrange
        val beforePay = 500000
        val nowPay = 150000
        //act
        val result = Main.isLimitForCardExceptVKPay(
            beforePay = beforePay,
            nowPay = nowPay
        )
        //assert
        assertEquals(true, result)
    }
    @Test
    fun isLimitForCardExceptVKPayTrueNowPay() {
        //arrange
        val beforePay = 300000
        val nowPay = 160000
        //act
        val result = Main.isLimitForCardExceptVKPay(
            beforePay = beforePay,
            nowPay = nowPay
        )
        //assert
        assertEquals(true, result)
    }
    @Test
    fun isLimitForCardExceptVKPayFalse() {
        //arrange
        val beforePay = 200000
        val nowPay = 100000
        //act
        val result = Main.isLimitForCardExceptVKPay(
            beforePay = beforePay,
            nowPay = nowPay
        )
        //assert
        assertEquals(false, result)
    }

    @Test
    fun isLimitForVKPayTrueBeforePay() {
        //arrange
        val beforePay = 39000
        val nowPay = 2000
        //act
        val result = Main.isLimitForVKPay(
            beforePay = beforePay,
            nowPay = nowPay
        )
        //assert
        assertEquals(true, result)
    }

    @Test
    fun isLimitForVKPayTrueNowPay() {
        //arrange
        val beforePay = 10000
        val nowPay = 16000
        //act
        val result = Main.isLimitForVKPay(
            beforePay = beforePay,
            nowPay = nowPay
        )
        //assert
        assertEquals(true, result)
    }

    @Test
    fun isLimitForVKPayTrueFalse() {
        //arrange
        val beforePay = 10000
        val nowPay = 10000
        //act
        val result = Main.isLimitForVKPay(
            beforePay = beforePay,
            nowPay = nowPay
        )
        //assert
        assertEquals(false, result)
    }
}