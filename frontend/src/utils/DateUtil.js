import dayjs from 'dayjs';
import timezone from 'dayjs/plugin/timezone';
import utc from 'dayjs/plugin/utc';

dayjs.extend(utc);
dayjs.extend(timezone);

export default class DateUtil {
  /**
   * Date 객체 return
   * @param {*} date 
   * @returns {Date}
   */
  static getDateObj(date) {
    return dayjs(date).toDate()
  }

  /**
   * 현재의 연/월/일 return
   * @param {*} yms 
   * @returns 
   */
  static getYMS(yms) {
    return dayjs().get(yms)
  }

  /**
   * 인자의 연/월에 해당하는 날짜 수 return
   * @param {*} day 
   * @returns 
   */
  static getLastDayOfMonth(YM) {
    return dayjs(YM + '-01').daysInMonth();
  }

  /**
   * 인자의 연/월에 해당하는 날짜의 List return
   * @param {*} YM 
   * @returns 
   */
  static getDayListOfMonth(YM) {
    const dayList = [];
    const lastDay = this.getLastDayOfMonth(YM);
    for(let i=1; i<=lastDay; i++) {
      dayList.push(i);
    }
    return dayList;
  }

  static getUTCinSeoul() {
    return dayjs().tz("Asia/Seoul");
  }
}